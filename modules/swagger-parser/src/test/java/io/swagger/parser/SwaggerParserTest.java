package io.swagger.parser;

import io.swagger.models.ModelImpl;
import io.swagger.models.Swagger;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SwaggerParserTest {

    @Test
    public void testNumberAttributes() throws Exception {
        System.out.println("1:" + getClass().getResource("/number_attributes.yaml").getFile());
        System.out.println("1:" + getClass().getResource("/number_attributes.yaml").toURI());
        System.out.println("1:" + new File(getClass().getResource("/number_attributes.yaml").toURI()).getAbsolutePath());
        System.out.println("1:" + new File(getClass().getResource("/number_attributes.yaml").toURI()).exists());
        
        SwaggerParser parser = new SwaggerParser();
        Swagger swagger = parser.read(getClass().getResource("/number_attributes.yaml").getFile());

        ModelImpl numberType = (ModelImpl)swagger.getDefinitions().get("NumberType");
        assertNotNull(numberType);
        assertNotNull(numberType.getEnum());
        assertEquals(numberType.getEnum().size(), 2);
        List<String> numberTypeEnumValues = numberType.getEnum();
        assertEquals(numberTypeEnumValues.get(0), "1.0");
        assertEquals(numberTypeEnumValues.get(1), "2.0");
        assertEquals(numberType.getDefaultValue(), new BigDecimal("1.0"));
        assertEquals(numberType.getMinimum(), new BigDecimal("1.0"));
        assertEquals(numberType.getMaximum(), new BigDecimal("2.0"));

        ModelImpl numberDoubleType = (ModelImpl)swagger.getDefinitions().get("NumberDoubleType");
        assertNotNull(numberDoubleType);
        assertNotNull(numberDoubleType.getEnum());
        assertEquals(numberDoubleType.getEnum().size(), 2);
        List<String> numberDoubleTypeEnumValues = numberDoubleType.getEnum();
        assertEquals(numberDoubleTypeEnumValues.get(0), "1.0");
        assertEquals(numberDoubleTypeEnumValues.get(1), "2.0");
        assertEquals(numberDoubleType.getDefaultValue(), new BigDecimal("1.0"));
        assertEquals(numberDoubleType.getMinimum(), new BigDecimal("1.0"));
        assertEquals(numberDoubleType.getMaximum(), new BigDecimal("2.0"));

        ModelImpl integerType = (ModelImpl)swagger.getDefinitions().get("IntegerType");
        assertNotNull(integerType);
        assertNotNull(integerType.getEnum());
        assertEquals(integerType.getEnum().size(), 2);
        List<String> integerTypeEnumValues = integerType.getEnum();
        assertEquals(integerTypeEnumValues.get(0), "1");
        assertEquals(integerTypeEnumValues.get(1), "2");
        assertEquals(integerType.getDefaultValue(), new Integer("1"));
        assertEquals(integerType.getMinimum(), new BigDecimal("1"));
        assertEquals(integerType.getMaximum(), new BigDecimal("2"));

        ModelImpl integerInt32Type = (ModelImpl)swagger.getDefinitions().get("IntegerInt32Type");
        assertNotNull(integerInt32Type);
        assertNotNull(integerInt32Type.getEnum());
        assertEquals(integerInt32Type.getEnum().size(), 2);
        List<String> integerInt32TypeEnumValues = integerInt32Type.getEnum();
        assertEquals(integerInt32TypeEnumValues.get(0), "1");
        assertEquals(integerInt32TypeEnumValues.get(1), "2");
        assertEquals(integerInt32Type.getDefaultValue(), new Integer("1"));
        assertEquals(integerInt32Type.getMinimum(), new BigDecimal("1"));
        assertEquals(integerInt32Type.getMaximum(), new BigDecimal("2"));


    }

}