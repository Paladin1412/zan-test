package com.hu.zan;

/**
 * <p>TNC核心对外组网HSF服务接口，提供组网计算、发布、检查进度、获取版本检查信息等功能。</p>
 * <br></br>
 * <p><b>组网调用链路：</b>TNM通过HSF调用本服务，提交组网计算 => TNC组网计算 => TNM实时查询组网进度 => TNM调用TNC执行组网发布</p>
 * <br></br>
 * <p>TNM调用的方法列表如下：
 * <ol>
 * <li>提交组网计算</li>
 * </ol>
 * </p>
 *
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/13 15/57
 */
public class DynamicCreateObjectUtil {

    private final static String SETTER_STR = "set";
    private final static String GETTER_STR = "get";

    //public Object addField(String className, Map<String, Object> fieldMap)
    //    throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
    //    //获取javassist类池
    //    ClassPool pool = ClassPool.getDefault();
    //    //创建javassist类
    //    CtClass ctClass = pool.makeClass(className, pool.get(Object.class.getName()));
    //    // 为创建的类ctClass添加属性
    //    Iterator it = fieldMap.entrySet().iterator();
    //    // 遍历所有的属性
    //    while (it.hasNext()) {
    //        Map.Entry entry = (Map.Entry)it.next();
    //        String fieldName = (String)entry.getKey();
    //        Object fieldValue = entry.getValue();
    //        // 增加属性，这里仅仅是增加属性字段
    //        String fieldType = fieldValue.getClass().getName();
    //        CtField ctField = new CtField(pool.get(fieldType), fieldName, ctClass);
    //        ctField.setModifiers(Modifier.PUBLIC);
    //        FieldInfo fieldInfo = ctField.getFieldInfo();
    //        ConstPool cp = fieldInfo.getConstPool();
    //        AnnotationsAttribute attribute2 = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
    //        Annotation annotation = new Annotation("javax.persistence.PersistenceContext", cp);
    //
    //        //修改名称为unitName的注解
    //        annotation.addMemberValue("name", new StringMemberValue("basic-entity", cp));
    //        attribute2.setAnnotation(annotation);
    //        fieldInfo.addAttribute(attribute2);
    //
    //        ctClass.addField(ctField);
    //    }
    //    // 为创建的javassist类转换为java类
    //    Class c = ctClass.toClass();
    //    // 为创建java对象
    //    Object newObject = c.newInstance();
    //    // 为创建的类newObject属性赋值
    //    it = fieldMap.entrySet().iterator();
    //    // 遍历所有的属性
    //    while (it.hasNext()) {
    //        Map.Entry entry = (Map.Entry)it.next();
    //        String fieldName = (String)entry.getKey();
    //        Object fieldValue = entry.getValue();
    //        // 为属性赋值
    //        this.setFieldValue(newObject, fieldName, fieldValue);
    //    }
    //    return newObject;
    //}
    //
    //public static Class createClass(String className, Map<String, Class> fieldMap,
    //    Map<String, Map<String, Object>> annotationMap)
    //    throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
    //    //获取javassist类池
    //    ClassPool pool = ClassPool.getDefault();
    //    //创建javassist类
    //    CtClass ctClass = pool.makeClass(className, pool.get(Object.class.getName()));
    //    // 为创建的类ctClass添加属性
    //    Iterator it = fieldMap.entrySet().iterator();
    //
    //    String setMethodName = null;
    //    String getMethodName = null;
    //
    //    // 遍历所有的属性
    //    while (it.hasNext()) {
    //        Map.Entry entry = (Map.Entry)it.next();
    //        String fieldName = (String)entry.getKey();
    //        Class fieldType = (Class)entry.getValue();
    //        CtField ctField = new CtField(pool.get(fieldType.getName()), fieldName, ctClass);
    //        ctField.setModifiers(Modifier.PUBLIC);
    //        FieldInfo fieldInfo = ctField.getFieldInfo();
    //
    //        Map<String, Object> filedAnnationMap = annotationMap.get(fieldName);
    //        if (filedAnnationMap != null) {
    //            ConstPool cp = fieldInfo.getConstPool();
    //            AnnotationsAttribute attribute = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
    //            Annotation[] annotations = new Annotation[filedAnnationMap.size()];
    //            int i = 0;
    //            for (Map.Entry<String, Object> annotationEntry : filedAnnationMap.entrySet()) {
    //                Annotation annotation = new Annotation(annotationEntry.getKey(), cp);
    //                Object value = annotationEntry.getValue();
    //                if (String.class.isAssignableFrom(value.getClass())) {
    //                    StringMemberValue stringMemberValue = new StringMemberValue(value.toString(), cp);
    //                    ArrayMemberValue arrayMemberValue = new ArrayMemberValue(cp);
    //                    StringMemberValue[] stringMemberValueArray = new StringMemberValue[1];
    //                    stringMemberValueArray[0] = stringMemberValue;
    //                    arrayMemberValue.setValue(stringMemberValueArray);
    //                    annotation.addMemberValue("value", arrayMemberValue);
    //                } else if (Integer.class.isAssignableFrom(value.getClass())) {
    //                    annotation.addMemberValue("value", new IntegerMemberValue(cp, (int)value));
    //                } else if (Array.class.isAssignableFrom(value.getClass())) {
    //
    //                }
    //                annotations[i++] = annotation;
    //            }
    //            attribute.setAnnotations(annotations);
    //            fieldInfo.addAttribute(attribute);
    //        }
    //
    //        ctClass.addField(ctField);
    //
    //        setMethodName = SETTER_STR + StringUtils.capitalize(fieldName);
    //        getMethodName = GETTER_STR + StringUtils.capitalize(fieldName);
    //
    //        CtMethod ageSetter = CtNewMethod.setter(setMethodName, ctField);
    //        ctClass.addMethod(ageSetter);
    //        CtMethod ageGetter = CtNewMethod.getter(getMethodName, ctField);
    //        ctClass.addMethod(ageGetter);
    //
    //    }
    //    // 为创建的javassist类转换为java类
    //    return ctClass.toClass();
    //}
    //
    ///**
    // * 获取对象属性赋值
    // *
    // * @param dObject
    // * @param fieldName 字段别名
    // * @return
    // */
    //public static Object getFieldValue(Object dObject, String fieldName) {
    //    Object result = null;
    //    try {
    //        // 获取对象的属性域
    //        Field fu = dObject.getClass().getDeclaredField(fieldName);
    //        try {
    //            // 设置对象属性域的访问属性
    //            fu.setAccessible(true);
    //            // 获取对象属性域的属性值
    //            result = fu.get(dObject);
    //        } catch (IllegalAccessException e) {
    //            e.printStackTrace();
    //        }
    //    } catch (NoSuchFieldException e) {
    //        e.printStackTrace();
    //    }
    //    return result;
    //
    //}
    //
    ///**
    // * 给对象属性赋值
    // *
    // * @param dObject
    // * @param fieldName
    // * @param val
    // * @return
    // */
    //public static Object setFieldValue(Object dObject, String fieldName, Object val) {
    //    Object result = null;
    //    try {
    //        // 获取对象的属性域
    //        Field fu = dObject.getClass().getDeclaredField(fieldName);
    //        try {
    //            // 设置对象属性域的访问属性
    //            fu.setAccessible(true);
    //            // 设置对象属性域的属性值
    //            fu.set(dObject, val);
    //            // 获取对象属性域的属性值
    //            result = fu.get(dObject);
    //        } catch (IllegalAccessException e) {
    //            e.printStackTrace();
    //        }
    //    } catch (NoSuchFieldException e) {
    //        e.printStackTrace();
    //    }
    //    return result;
    //
    //}

}
