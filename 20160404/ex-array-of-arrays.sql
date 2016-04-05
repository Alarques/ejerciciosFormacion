SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE INITIALIZE(NUM_INS NUMBER, CUSTOMERS_ARRAY ARRAY_TYPE, PRODUCTS_ARRAY M_ARRAY_TYPE) AS
BEGIN

  FOR TIMES IN 1..NUM_INS
  LOOP
    INSERT INTO EMPLOYEE (ID, NAME, DATE_OF_BIRTH, SURNAME) VALUES (SEQ_EMPLOYEE.NEXTVAL, 'Treballador '||SEQ_EMPLOYEE.CURRVAL, '01/01/2000', 'Cognom '||SEQ_EMPLOYEE.CURRVAL);
    
    FOR I IN 1..CUSTOMERS_ARRAY(TIMES)
    LOOP
      INSERT INTO CUSTOMER (ID, NAME, EMPLOYEE_ID, SURNAME) VALUES (SEQ_CUSTOMER.NEXTVAL, 'Client '||SEQ_CUSTOMER.CURRVAL, SEQ_EMPLOYEE.CURRVAL, 'Cognom '||SEQ_CUSTOMER.CURRVAL);
      
      FOR X IN 1..PRODUCTS_ARRAY(TIMES)(I)
      LOOP
        INSERT INTO PRODUCT (ID, NAME, DESCRIPTION) VALUES (SEQ_PRODUCT.NEXTVAL, 'Producte '||SEQ_PRODUCT.CURRVAL, 'Descripció '||SEQ_PRODUCT.CURRVAL);
        INSERT INTO PRODUCT_CUSTOMER (PRODUCT_ID, CUSTOMER_ID, CREATION_DATE) VALUES (SEQ_PRODUCT.CURRVAL, SEQ_CUSTOMER.CURRVAL, SYSDATE);
      END LOOP;
      
    END LOOP;
    
  END LOOP;
  
  COMMIT;
  
END;
/

CREATE OR REPLACE TYPE ARRAY_TYPE IS VARRAY(10) OF NUMBER(8);
CREATE OR REPLACE TYPE M_ARRAY_TYPE IS VARRAY(10) OF ARRAY_TYPE;

DECLARE
  CUSTOMERS_ARRAY ARRAY_TYPE;
  PRODUCTS_ARRAY M_ARRAY_TYPE;
BEGIN
  CUSTOMERS_ARRAY := ARRAY_TYPE(2, 1, 4);
  PRODUCTS_ARRAY := M_ARRAY_TYPE(ARRAY_TYPE(1,3),ARRAY_TYPE(2),ARRAY_TYPE(3,1,2,1));
  INITIALIZE(3, CUSTOMERS_ARRAY, PRODUCTS_ARRAY);
END;

ROLLBACK;