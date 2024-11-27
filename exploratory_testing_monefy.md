# Exploratory Testing Session - Monefy App

**Assumption**: The application tested is the iOS free version of the Monefy App.

## Exploration Charter 1: Adding Transactions
**Objective**: Evaluate how new transactions are added.

**Areas to Explore**:
- Addition flow
- Expense/income categories
- Confirmation/error messages

**Expectations**: Transactions should be easy to add and correctly categorized.

**Findings**:
- **Positive**: Categories for expenses and incomes are well-defined.
- **Positive**: The number of included categories are enough for normal app usage.
- **Positive**: Adding expenses/incomes transactions is straightforward.
- **Positive**: Future expenses/incomes can be added and filtered correctly on the dashboard.
- **Positive**: Confirmation and error messages are displayed correctly.
- **Positive**: Transactions can be backed up and restored, ensuring data is not lost.

---

## Exploration Charter 2: Account Creation
**Objective**: Verify the process account creation.

**Areas to Explore**:
- Field validation
- Error messages

**Expectations**: The creation process should be smooth, and all errors should be handled appropriately.

**Findings**:
- **Positive**: The account creation process is straightforward and user-friendly.
- **Positive**: Field validations are appropriate and provide clear feedback to the user.
- **Positive**: Error messages are displayed correctly when invalid data is entered.
- **Positive**: The number of included categories are enough for normal app usage.
---

## Exploration Charter 3: Account Balance Modification
**Objective**: Verify the modification of account balances and their reflection in the total balance.

**Areas to Explore**:
- Balance modification process
- Error handling
- Date of balance application

**Expectations**: Modifying account balances should be straightforward, and changes should be accurately reflected in the total balance.

**Findings**:
- **Positive**: The balance modification process is intuitive and user-friendly.
- **Positive**: Validations are handled correctly and provide clear feedback to the user.
- **Positive**: Future-dated balance modifications are applied correctly, and the date range can be filtered on the main dashboard.

---

## Exploration Charter 4: Report Visualization
**Objective**: Examine the functionality of reports and charts.

**Areas to Explore**:
- Types of reports
- Data accuracy
- User interface

**Expectations**: Reports should be clear, accurate, and easy to interpret.

**Findings**:
- **Positive**: The distribution of expenses in the report is displayed correctly and intuitively.
- **Positive**: The visualization of transactions by dates and future projections is correct.
- **Positive**: Transactions can be exported to a CSV file, allowing for easy data backup and analysis.
- **Negative**: The dashboard is initially filtered to display only the credit card account, which may lead to user confusion as it does not present the total balance of all accounts.

---

## Exploration Charter 5: Backup and Restore
**Objective**: Verify the functionality of creating backups and restoring from them.

**Areas to Explore**:
- Backup creation process
- Restore process
- Data integrity after restore

**Expectations**: Users should be able to create backups and restore from them without data loss or corruption.

**Findings**:
- **Positive**: The backup creation process is straightforward and user-friendly.
- **Positive**: Backups are created quickly and stored correctly.
- **Positive**: The restore process is intuitive and easy to follow.
- **Positive**: Data integrity is maintained after restoring from a backup.
- **Positive**: Confirmation messages are displayed correctly during backup and restore operations.
- **Positive**: Error messages are displayed correctly when the backup or restore process fails.

---

## Charter Prioritization

1. **Adding Transactions**
    - **Priority**: High
    - **Reason**: Critical functionality with mostly positive findings, but essential for app usage.

2. **Report Visualization and Dashboard**
    - **Priority**: High
    - **Reason**: The dashboard is the first screen users see, and accurate report visualization is crucial for user satisfaction.

3. **Account Balance Modification**
    - **Priority**: Medium
    - **Reason**: Important for accurate financial tracking, but no critical issues were identified.

4. **Backup and Restore**
    - **Priority**: Medium
    - **Reason**: Ensures data safety and integrity, important for user trust.

5. **Account Creation**
    - **Priority**: Low
    - **Reason**: Not the first user interaction, and no major issues were found.

---

## Risks and Mitigation
- **Regression Risk**: Future changes may introduce new issues.
    - **Mitigation**: Implement automated regression tests.
- **Coverage Risk**: Not all scenarios may have been tested.
    - **Mitigation**: Expand test cases to cover more scenarios.
- **Usability Risk**: User experience may not be optimal.
    - **Mitigation**: Conduct usability testing with real users.


## Recommendations
- **Enhance Authentication**: Consider adding multi-factor authentication in the free version to improve security.
- **Conduct Regular Security Audits**: Perform regular security audits and penetration testing to identify and mitigate potential vulnerabilities.