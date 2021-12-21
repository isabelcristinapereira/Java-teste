package com.clienteapi.crm.model;

import java.time.LocalDate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClienteTest {
      Cliente cliente;
      Cliente clienteNulo;
     
      @Autowired
      private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      Validator validator = factory.getValidator();
     
      @BeforeEach
      public void start() {
    	  LocalDate data= LocalDate.parse("2000-12-12",DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
    	  cliente= new Cliente(0L,"Isabel","33998764523",data);
    	  
    	  clienteNulo= new Cliente(0L,"","33998764523",data);
     }
      
      @Test
      @DisplayName("✔ Valida Atributos Não Nulos")
      void testValidaAtributos() {
        Set<ConstraintViolation<Cliente>> violacao = validator.validate(cliente);
        System.out.println(violacao.toString());
        assertTrue(violacao.isEmpty());
      }
      
      @Test
      @DisplayName("✖ Valida Atributos Nulos") 
      void testNaoValidaAtributos() {
        Set<ConstraintViolation<Cliente>> violacao = validator.validate(clienteNulo);
        System.out.println(violacao.toString());
        assertFalse(violacao.isEmpty()); 
      }


}
