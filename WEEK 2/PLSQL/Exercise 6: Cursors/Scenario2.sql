DECLARE
    CURSOR accounts_cur IS
        SELECT AccountID, Balance
        FROM Accounts;
    v_annual_fee NUMBER := 50; 
BEGIN
    FOR rec IN accounts_cur LOOP
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee
        WHERE AccountID = rec.AccountID;        
        DBMS_OUTPUT.PUT_LINE('Annual fee deducted from Account ID ' || rec.AccountID);
    END LOOP;    
    COMMIT;
END;
/
