DECLARE

  E_NAME VARCHAR2(50);
  E_ID NUMBER(8);
  C_NAME VARCHAR2(50);
  C_ID NUMBER(8);    
  
BEGIN

  --Buscar el trabajador con m�s clientes
  SELECT E.ID,E.NAME INTO E_ID, E_NAME
  FROM EMPLOYEE E
    LEFT OUTER JOIN CUSTOMER C ON(E.ID=C.EMPLOYEE_ID)
  GROUP BY E.NAME, E.ID
  HAVING COUNT(C.EMPLOYEE_ID)=(
    SELECT MAX(COUNT(C.EMPLOYEE_ID))-- INTO C_ID
    FROM EMPLOYEE E
      LEFT OUTER JOIN CUSTOMER C ON(E.ID=C.EMPLOYEE_ID)
    GROUP BY E.ID
  );
  
  DBMS_OUTPUT.PUT_LINE('El trabajador con mas clientes: ' || E_NAME);
  
  --Buscar el cliente de ese trabajador con m�s productos relacionados
  
  SELECT PC.CUSTOMER_ID INTO C_ID
  FROM PRODUCT_CUSTOMER PC
    INNER JOIN CUSTOMER C ON(PC.CUSTOMER_ID=C.ID) AND (C.EMPLOYEE_ID=E_ID)
    GROUP BY PC.CUSTOMER_ID
  HAVING COUNT(PC.CUSTOMER_ID)=(
    SELECT MAX(COUNT(CUSTOMER_ID))
      FROM PRODUCT_CUSTOMER
    GROUP BY CUSTOMER_ID
  );
  
  SELECT NAME INTO C_NAME
  FROM CUSTOMER
  WHERE ID=C_ID;
  
  --Mostrar el nombre
  DBMS_OUTPUT.PUT_LINE('Nombre cliente: ' || C_NAME);
  
END;