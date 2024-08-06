CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount (p_CustomerID IN NUMBER, p_AccountType IN VARCHAR2, p_InitialBalance IN NUMBER);
    PROCEDURE CloseAccount (p_AccountID IN NUMBER);
    FUNCTION GetTotalBalance (p_CustomerID IN NUMBER) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount (p_CustomerID IN NUMBER, p_AccountType IN VARCHAR2, p_InitialBalance IN NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (Accounts_SEQ.NEXTVAL, p_CustomerID, p_AccountType, p_InitialBalance, SYSDATE);
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END OpenAccount;
    PROCEDURE CloseAccount (p_AccountID IN NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END CloseAccount;
    FUNCTION GetTotalBalance (p_CustomerID IN NUMBER) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_TotalBalance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;        
        RETURN NVL(v_TotalBalance, 0);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN 0;
    END GetTotalBalance;
END AccountOperations;
/
