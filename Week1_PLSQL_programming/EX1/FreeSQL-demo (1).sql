DECLARE
    CURSOR c2 IS
        SELECT CustomerID, Balance
        FROM Customers;

BEGIN
    FOR rec IN c2 LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || rec.CustomerID || ' promoted to VIP.'
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/