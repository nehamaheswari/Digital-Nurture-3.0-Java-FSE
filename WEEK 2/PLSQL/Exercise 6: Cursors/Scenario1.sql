SET SERVEROUTPUT ON;
DECLARE
    CURSOR monthly_transactions_cur IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE);
    v_statement VARCHAR2(4000); 
BEGIN
    FOR rec IN monthly_transactions_cur LOOP
        v_statement := 'Customer: ' || rec.Name || ', Transaction ID: ' || rec.TransactionID ||
                       ', Date: ' || TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD') ||
                       ', Amount: ' || rec.Amount || ', Type: ' || rec.TransactionType;
        DBMS_OUTPUT.PUT_LINE(v_statement);
    END LOOP;
END;
/
