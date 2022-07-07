import java.util.ArrayList;
import java.util.HashMap;
public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // Замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);

        if (expensesByCategories.containsKey(category)){

            for(ArrayList<Double> exp: expensesByCategories.values())
            {
                exp.add(expense);
            }

        } else{
            ArrayList<Double> expanseList = new ArrayList<>();
            expanseList.add(expense);
            expensesByCategories.put(category, expanseList);

        }

        if(moneyBeforeSalary < 1000){
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }

        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories(){ // Замените логику для работы с таблицами
        for(String category: expensesByCategories.keySet()){
            System.out.println(category);
            for(Double expanse : expensesByCategories.get(category)){
                System.out.println(expanse);
            }
        }
    }

    double findMaxExpenseInCategory(String category){
        double maxExpense = 0;

        if (expensesByCategories.containsKey(category)){
            for(Double expanse : expensesByCategories.get(category)) {
                if(maxExpense < expanse){
                    maxExpense = expanse;
                }
            }

        } else System.out.println("Такой категории пока нет.");

        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
    }

}
