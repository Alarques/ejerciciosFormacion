--Utilizad la sequencia para insertar 3 productos nuevos.
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION) VALUES (SEQ_PRODUCT.NEXTVAL, 'Producte 1','Descripció del producte 1');
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION) VALUES (SEQ_PRODUCT.NEXTVAL, 'Producte 2','Descripció del producte 2');
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION) VALUES (SEQ_PRODUCT.NEXTVAL, 'Producte 3','Descripció del producte 3');

--Después de los tres inserts iniciales, reiniciad la secuencia y volved a ejecutar los tres inserts
DROP SEQUENCE SEQ_PRODUCT;

CREATE SEQUENCE SEQ_PRODUCT
  START WITH 1
  INCREMENT BY 1;