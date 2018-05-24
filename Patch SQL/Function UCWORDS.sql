DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `UCWORDS` (`STR` TEXT) RETURNS TEXT CHARSET latin1 BEGIN
  DECLARE C CHAR(1);
  DECLARE S TEXT;
  DECLARE I INT DEFAULT 1;
  DECLARE BOOL INT DEFAULT 1;
  DECLARE PUNCT CHAR(17) DEFAULT ' ()[]{},.-_!@;:?/';
  SET S = LCASE(STR);
  WHILE I <= LENGTH(STR) DO
    BEGIN
	  SET C = SUBSTRING(S, I, 1);
      IF LOCATE(C, PUNCT) > 0 THEN
	    SET BOOL = 1;
      ELSEIF BOOL = 1 THEN
	    BEGIN
	      IF C >= 'a' AND C <= 'z' THEN
		    BEGIN
		      SET S = CONCAT(LEFT(S, I-1), UCASE(C), SUBSTRING(S, I+1));
              SET BOOL = 0;
            END;
          ELSEIF C >= '0' AND C <= '9' THEN
		    SET BOOL = 0;
          END IF;
        END;
      END IF;
      SET I = I+1;
    END;
  END WHILE;
  RETURN S;
END$$

DELIMITER ;