package com.hu.zan;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.analysis.ExcelReadExecutor;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-01-18 22:21
 * @Description
 **/
public class CaffeineDemo {

    @Test
    public void caffeine() throws Exception {
        //String fileAddress =
        // "/Users/hupeng/Downloads/预提模板-部分匹配_e3d127033b21473b9b775e3c2538a02e_f632b1b1ba464b6ea0adbf72f2ec380c.xlsx";
        //File file = new File(fileAddress);
        //FileInputStream fileInputStream = new FileInputStream(file);
        //EasyExcel.read(fileInputStream, new NoModelNewDataListener()).sheet().doRead();
        Map<String, String> hashMap = new LinkedHashMap();
        hashMap.put("1", "");
        hashMap.put("2", "");
        System.out.println(JSON.toJSONString(hashMap));
        System.out.println(JSON.toJSONString(null));
    }

    //public static String toLowerCaseFirstOne(String s) {
    //    if (Character.isLowerCase(s.charAt(0))) {
    //        return s;
    //    } else {
    //        return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    //    }
    //}
    //
    //public Class getExcelVOClass(Map<String, String> fieldMap)
    //    throws Exception {
    //    Map<String, Class> excelFieldMap = new HashMap<String, Class>();
    //    int index = 0;
    //    Map<String, Map<String, Object>> annotationMap = new HashMap<>();
    //    List<String> fieldCodeList = new ArrayList<>(fieldMap.keySet());
    //    Collections.sort(fieldCodeList);
    //    for (String fieldCode : fieldCodeList) {
    //        excelFieldMap.put(fieldCode, String.class);
    //        Map<String, Object> filedAnnotationMap = new HashMap<>();
    //        filedAnnotationMap.put("com.alibaba.excel.annotation.ExcelColumnNum", index++);
    //        filedAnnotationMap.put("com.alibaba.excel.annotation.ExcelProperty", fieldMap.get(fieldCode));
    //        annotationMap.put(fieldCode, filedAnnotationMap);
    //    }
    //    Class result = getClass("com.alibaba.excel.metadata.BaseRowModel",
    //        excelFieldMap, annotationMap);
    //    return result;
    //
    //}
    //
    //static Map<String, Class> cache = new WeakHashMap<>();
    //
    //public static Class getClass(String className, Map<String, Class> fieldMap,
    //    Map<String, Map<String, Object>> annotationMap) throws Exception {
    //    String createClassName = className + "$" + generateClassName(fieldMap);
    //    if (cache.get(createClassName) == null) {
    //        Class clazz = createClass(createClassName, fieldMap, annotationMap);
    //        cache.put(createClassName, clazz);
    //        return clazz;
    //    } else {
    //        return cache.get(createClassName);
    //    }
    //
    //}
    //
    //public static int generateClassName(Map<String, Class> fieldMap) {
    //    StringBuilder nameBuilder = new StringBuilder();
    //    Iterator it = fieldMap.entrySet().iterator();
    //    while (it.hasNext()) {
    //        Map.Entry entry = (Map.Entry)it.next();
    //        nameBuilder.append(entry.getKey()).append("==").append(entry.getValue());
    //    }
    //
    //    return nameBuilder.toString().hashCode();
    //}
    //
    //public static Class createClass(String className, Map<String, Class> fieldMap,
    //    Map<String, Map<String, Object>> annotationMap) throws Exception {
    //    ClassPool pool = ClassPool.getDefault();
    //
    //    CtClass baseRowModelClass = null;
    //    try {
    //        baseRowModelClass = pool.get(BaseRowModel.class.getName());
    //    } catch (NotFoundException e) {
    //        baseRowModelClass = pool.makeClass(BaseRowModel.class.getName());
    //        CtConstructor ctConstructor = new CtConstructor(new CtClass[] {}, baseRowModelClass);
    //        baseRowModelClass.addConstructor(ctConstructor);
    //    }
    //    //添加构造函数
    //
    //    CtClass ctClass = null;
    //    try {
    //        ctClass = pool.get(className);
    //    } catch (NotFoundException e) {
    //        ctClass = pool.makeClass(className, baseRowModelClass);
    //    }
    //
    //    Iterator it = fieldMap.entrySet().iterator();
    //    String setMethodName = null;
    //    String getMethodName = null;
    //
    //    while (it.hasNext()) {
    //        Map.Entry entry = (Map.Entry)it.next();
    //        String fieldName = (String)entry.getKey();
    //        Class fieldType = (Class)entry.getValue();
    //        CtField ctField = new CtField(pool.get(fieldType.getName()), fieldName, ctClass);
    //        ctField.setModifiers(1);
    //        FieldInfo fieldInfo = ctField.getFieldInfo();
    //        Map<String, Object> filedAnnotationMap = (Map)annotationMap.get(fieldName);
    //        if (filedAnnotationMap != null) {
    //            ConstPool cp = fieldInfo.getConstPool();
    //            AnnotationsAttribute attribute = new AnnotationsAttribute(cp, "RuntimeVisibleAnnotations");
    //            Annotation[] annotations = new Annotation[filedAnnotationMap.size()];
    //            int i = 0;
    //
    //            Annotation annotation;
    //            int index = 9;
    //            for (Iterator var18 = filedAnnotationMap.entrySet().iterator(); var18.hasNext();
    //                 annotations[i++] = annotation) {
    //                Map.Entry<String, Object> annotationEntry = (Map.Entry)var18.next();
    //                annotation = new Annotation((String)annotationEntry.getKey(), cp);
    //                Object value = annotationEntry.getValue();
    //                if (String.class.isAssignableFrom(value.getClass())) {
    //                    StringMemberValue stringMemberValue = new StringMemberValue(value.toString(), cp);
    //                    ArrayMemberValue arrayMemberValue = new ArrayMemberValue(cp);
    //                    StringMemberValue[] stringMemberValueArray = new StringMemberValue[] {stringMemberValue};
    //                    arrayMemberValue.setValue(stringMemberValueArray);
    //                    annotation.addMemberValue("value", arrayMemberValue);
    //                    index = index + 1;
    //                    annotation.addMemberValue("index", new IntegerMemberValue(cp, index));
    //                } else if (Integer.class.isAssignableFrom(value.getClass())) {
    //                    annotation.addMemberValue("value", new IntegerMemberValue(cp, (Integer)value));
    //                } else if (Array.class.isAssignableFrom(value.getClass())) {
    //                }
    //            }
    //
    //            attribute.setAnnotations(annotations);
    //            fieldInfo.addAttribute(attribute);
    //        }
    //
    //        ctClass.addField(ctField);
    //        setMethodName = "set" + StringUtils.capitalize(fieldName);
    //        getMethodName = "get" + StringUtils.capitalize(fieldName);
    //        CtMethod ageSetter = CtNewMethod.setter(setMethodName, ctField);
    //        ctClass.addMethod(ageSetter);
    //        CtMethod ageGetter = CtNewMethod.getter(getMethodName, ctField);
    //        ctClass.addMethod(ageGetter);
    //    }
    //    return ctClass.toClass();
    //}
}
