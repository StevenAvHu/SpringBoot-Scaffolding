package com.myJar.bussiness.bean;

import com.myJar.bussiness.annations.UserCode;
import com.myJar.bussiness.annations.ImCustNo;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 胡宇鑫
 * @date 2023/7/18 13:48
 * @description 数据读取缓存
 */
@Slf4j
public class CheckFieldManager {
    /**
     * 用于代码优化，公用方法的缓存
     */
    private static final ConcurrentHashMap<Class<? extends Annotation>, ConcurrentReferenceHashMap<String, Field>> ANNOTATION_FIELD_MAP = new ConcurrentHashMap<>();

    /**
     * userCode 字段缓存
     */
    private static final ConcurrentReferenceHashMap<String, Field> USER_CODE_FIELD_MAP = new ConcurrentReferenceHashMap<>(16, ConcurrentReferenceHashMap.ReferenceType.WEAK);

    /**
     * imCustNo 字段缓存
     */
    private static final ConcurrentReferenceHashMap<String, Field> IM_CUST_NO_FIELD_MAP = new ConcurrentReferenceHashMap<>(16, ConcurrentReferenceHashMap.ReferenceType.WEAK);

    /**
     * 放入公共缓存中
     */
    static {
        ANNOTATION_FIELD_MAP.put(UserCode.class, USER_CODE_FIELD_MAP);
        ANNOTATION_FIELD_MAP.put(ImCustNo.class, IM_CUST_NO_FIELD_MAP);
    }

    @Nullable
    public static Field getUserCodeField(Class<?> clazz, @Nullable String fieldName) {
        return getSingleField(clazz, UserCode.class, fieldName);
    }

    @Nullable
    public static Field getImCustNoField(Class<?> clazz, @Nullable String fieldName) {
        return getSingleField(clazz, ImCustNo.class, fieldName);
    }

    @Nullable
    private static Field getSingleField(Class<?> clazz, Class<? extends Annotation> annotation, @NonNull String fieldName) {
        String className = clazz.getName();
        ConcurrentReferenceHashMap<String, Field> fieldMap = ANNOTATION_FIELD_MAP.get(annotation);
        Field field = fieldMap.get(className);
        if (Objects.isNull(field)) {
            field = getField(clazz, annotation, fieldName);
            fieldMap.put(className, field);
        }
        return field;
    }

    @Nullable
    private static Field getField(Class<?> clazz, Class<? extends Annotation> annotation, @NonNull String fieldName) {
        Field annotationField = null;
        Field nameField = null;
        String clazzName = clazz.getName();
        while (Objects.nonNull(clazz)) {
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                // 获取注解
                Annotation exists = field.getAnnotation(annotation);
                if (Objects.nonNull(exists) && Objects.isNull(annotationField)) {
                    annotationField = field;
                }
            }
            try {
                Field field = clazz.getDeclaredField(fieldName);
                if (Objects.isNull(nameField)) {
                    nameField = field;
                }
            } catch (NoSuchFieldException e) {
                // do nothing
            }
            // 获取父类
            clazz = clazz.getSuperclass();
        }
        return Objects.nonNull(annotation) ? annotationField : Optional.ofNullable(nameField).orElseGet(() -> {
            String message = String.format("%s类没有加%s注解的属性，也没有%s属性", clazzName, annotation.getName(), fieldName);
            log.error(message);
            return null;
        });
    }

}
