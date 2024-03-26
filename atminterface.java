class BankAccount:
    def _init_(self, balance=0):
        self.balance = balance

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            return True
        else:
            print("Invalid deposit amount.")
            return False

    def withdraw(self, amount):
        if amount <= self.balance:
            self.balance -= amount
            return True
        else:
            print("Insufficient funds.")
            return False

    def check_balance(self):
        return self.balance


class ATM:
    def _init_(self, bank_account):
        self.bank_account = bank_account

    def display_options(self):
        print("1. Withdraw")
        print("2. Deposit")
        print("3. Check Balance")

    def withdraw(self, amount):
        if self.bank_account.withdraw(amount):
            print(f"Withdrawn {amount} successfully.")
        else:
            print("Withdrawal failed.")

    def deposit(self, amount):
        if self.bank_account.deposit(amount):
            print(f"Deposited {amount} successfully.")
        else:
            print("Deposit failed.")

    def check_balance(self):
        balance = self.bank_account.check_balance()
        print(f"Your balance is: {balance}")


def main():
    user_account = BankAccount(1000)
    atm = ATM(user_account)

    while True:
        atm.display_options()
        choice = input("Enter your choice: ")

        if choice == '1':
            amount = float(input("Enter amount to withdraw: "))
            atm.withdraw(amount)
        elif choice == '2':
            amount = float(input("Enter amount to deposit: "))
            atm.deposit(amount)
        elif choice == '3':
            atm.check_balance()
        else:
            print("Invalid choice. Please try again.")


if _name_ == "_main_":
    main()
