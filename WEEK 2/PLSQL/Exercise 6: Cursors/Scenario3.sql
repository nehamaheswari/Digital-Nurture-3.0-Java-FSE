DECLARE
    CURSOR loans_cur IS
        SELECT LoanID, InterestRate
        FROM Loans;
    v_new_policy_interest_rate NUMBER := 4.5; 
BEGIN
    FOR rec IN loans_cur LOOP
        UPDATE Loans
        SET InterestRate = v_new_policy_interest_rate
        WHERE LoanID = rec.LoanID;        
        DBMS_OUTPUT.PUT_LINE('Updated interest rate for Loan ID ' || rec.LoanID);
    END LOOP;    
    COMMIT;
END;
/
