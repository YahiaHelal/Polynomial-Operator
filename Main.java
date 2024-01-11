import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    //static int SkipSteps;
    //static boolean Skip;
    public static void main(String[] args) throws IOException {
        PolyDataLinkedList<String> polynomialOperator = new PolyDataLinkedList<>();
        Draw();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = reader.readLine();
        while(!(Validations.isDigit(choice)) || Integer.parseInt(choice) > 4 || Integer.parseInt(choice) < 0){
            System.out.println("There is no choice called "+choice+"\n");
            Draw();
            choice = reader.readLine();
        }
        String equation;
        String equation1;
        String equation2;
        String value;
        switch (Integer.parseInt(choice)) {
            case 1 -> {
                System.out.println("Enter the first equation\n----> ");
                equation1 = reader.readLine();
                equation1 = equation1.replaceAll("\\s+", "");
                System.out.println("Enter the second equation\n----> ");
                equation2 = reader.readLine();
                equation2 = equation2.replaceAll("\\s+", "");
                while (!(Validations.IsPolynomialForm(equation1) || !(Validations.IsPolynomialForm(equation2)))) {
                    System.out.println("that does not seem to be correct polynomial form please try again\n");
                    System.out.println("Enter the first equation\n----> ");
                    equation1 = reader.readLine();
                    equation1 = equation1.replaceAll("\\s+", "");
                    System.out.println("Enter the second equation\n----> ");
                    equation2 = reader.readLine();
                    equation2 = equation2.replaceAll("\\s+", "");
                }
                System.out.println("The result of " + equation1 + " * " + equation2 + " is");
                System.out.println("---> " + Multiply(equation1, equation2));
            }
            case 2 -> {
                System.out.println("Enter the equation you wish to evaluate\n--->");
                equation = reader.readLine();
                equation = equation.replace("\\s+", "");
                System.out.println("Enter the value to evaluate\n--->");
                value = reader.readLine();
                value = value.replace("\\s+", "");
                while (!(Validations.isDigit(value))) {
                    System.out.println("\"" + value + "\" does not seem to be a number\n");
                    System.out.println("Enter the value to evaluate\n--->");
                    value = reader.readLine();
                    value = value.replace("\\s+", "");
                }
                System.out.println("The result of " + equation + " At x = " + value + " is\n");
                System.out.println("---> " + Evaluate(equation, Double.parseDouble(value)));
            }
            case 3 -> {
                System.out.println("Enter the first equation\n----> ");
                equation1 = reader.readLine();
                equation1 = equation1.replaceAll("\\s+", "");
                System.out.println("Enter the second equation\n----> ");
                equation2 = reader.readLine();
                equation2 = equation2.replaceAll("\\s+", "");
                while (!(Validations.IsPolynomialForm(equation1) || !(Validations.IsPolynomialForm(equation2)))) {
                    System.out.println("that does not seem to be correct polynomial form please try again\n");
                    System.out.println("Enter the first equation\n----> ");
                    equation1 = reader.readLine();
                    equation1 = equation1.replaceAll("\\s+", "");
                    System.out.println("Enter the second equation\n----> ");
                    equation2 = reader.readLine();
                    equation2 = equation2.replaceAll("\\s+", "");
                }
                System.out.println("The result of " + equation1 + " added to " + equation2 + " is");
                System.out.println("---> " + Add(equation1, equation2));
            }
            case 4 -> {
                System.out.println("Enter the first equation\n----> ");
                equation1 = reader.readLine();
                equation1 = equation1.replaceAll("\\s+", "");
                System.out.println("Enter the second equation\n----> ");
                equation2 = reader.readLine();
                equation2 = equation2.replaceAll("\\s+", "");
                while (!(Validations.IsPolynomialForm(equation1) || !(Validations.IsPolynomialForm(equation2)))) {
                    System.out.println("that does not seem to be correct polynomial form please try again\n");
                    System.out.println("Enter the first equation\n----> ");
                    equation1 = reader.readLine();
                    equation1 = equation1.replaceAll("\\s+", "");
                    System.out.println("Enter the second equation\n----> ");
                    equation2 = reader.readLine();
                    equation2 = equation2.replaceAll("\\s+", "");
                }
                System.out.println("The result of " + equation1 + " substracted from " + equation2 + " is");
                System.out.println("---> " + Substract(equation1, equation2));
            }
            case 0 -> System.out.println("Thank you for testing :\"D");
        }
    }

    public static void Draw() {
        System.out.println("\t\t\t\t\t|------------------|");
        System.out.println("\t\t\t\t\t|PolynomialOperator|");
        System.out.println("\t\t\t\t\t|------------------|");
        System.out.println("\t\t\t\t\t         |");
        System.out.println("\t\t\t\t\t         |");
        System.out.println("\t\t\t\t\t         |");
        System.out.println("\t       -------------------------------------------------------------------");
        System.out.println("\t       |                   |             |           |                    |");
        System.out.println("\t       |                   |             |           |                    |");
        System.out.println("\t       |                   |             |           |                    |");
        System.out.println("\t |------------|       |-----------|      |     |------------|     |------------------|");
        System.out.println("\t |Multuiply[1]|       |Evaluate[2]|      |     |Addition [3]|     | Substraction [4] |");
        System.out.println("\t |------------|       |-----------|      |     |------------|     |------------------|");
        System.out.println("\t                                         |                                          ");
        System.out.println("\t                                     |-------|");
        System.out.println("\t                                     |Exit[0]|");
        System.out.println("\t                                     |-------|");

    }

    public static String Multiply(String Eqn1 , String Eqn2) {
        //case all the same variable
        PolyDataLinkedList<String> Eqn1Data = new PolyDataLinkedList<>();
        PolyDataLinkedList<String> Eqn2Data = new PolyDataLinkedList<>();
        ExtractData(Eqn1, Eqn1Data);
        ExtractData(Eqn2, Eqn2Data);
        PolydataNode<String> current1 = Eqn1Data.getFirst();
        PolydataNode<String> current2 = Eqn2Data.getFirst();
        if(current1 == null || current2 == null) {
            return "";
        }
        String MultipliedCoeff ="";
        String MultipliedPower = "";
        PolyDataLinkedList<String> FormedEquation = new PolyDataLinkedList<>();
        while(current1 != null) {
            current2 = Eqn2Data.getFirst();
            while(current2 != null) {
                MultipliedCoeff = Integer.toString(Integer.parseInt(current1.Coeff) * Integer.parseInt(current2.Coeff));
                MultipliedPower = Integer.toString(Integer.parseInt(current1.Power) + Integer.parseInt(current2.Power));
                FormedEquation.Add(MultipliedCoeff, MultipliedPower);
                current2 = current2.next;
            }
            current1 = current1.next;
        }
        //return FormEquation(FormedEquation);
        return FormEquation(FormedEquation);
    }
    public static double Evaluate(String equation, double value) {
        PolyDataLinkedList<String> Data = new PolyDataLinkedList<>();
        ExtractData(equation, Data);
        PolydataNode<String> current = Data.getFirst();
        double result = value;
        double evaluated = 0;
        while(current != null) {
            result = Math.pow(value,Double.parseDouble(current.Power));
            result *= Double.parseDouble(current.Coeff);
            evaluated+=result;
            result = value;
            current = current.next;
        }
        return evaluated;

    }

    public static String Add(String equation1 , String equation2) {
        //case all the same variable
        PolyDataLinkedList<String> Eqn1Data = new PolyDataLinkedList<>();
        PolyDataLinkedList<String> Eqn2Data = new PolyDataLinkedList<>();
        ExtractData(equation1, Eqn1Data);
        ExtractData(equation2, Eqn2Data);
        PolydataNode<String> current1 = Eqn1Data.getFirst();
        PolydataNode<String> current2 = Eqn2Data.getFirst();
        PolyDataLinkedList<String> FormedEquation = new PolyDataLinkedList<>();
        while(current1 != null && current2 != null) {
            if(!Objects.equals(current1.Power, "") && !Objects.equals(current2.Power, "")) {
                if(Integer.parseInt(current1.Power) > Integer.parseInt(current2.Power)) {
                    FormedEquation.Add(current1.Coeff,current1.Power);
                    current1 = current1.next;
                }else if(Integer.parseInt(current2.Power) > Integer.parseInt(current1.Power)) {
                    FormedEquation.Add(current2.Coeff,current2.Power);
                    current2 = current2.next;
                }else {
                    String newCoeff = Integer.toString(Integer.parseInt(current1.Coeff)+Integer.parseInt(current2.Coeff));
                    FormedEquation.Add(newCoeff,current1.Power);
                    current1 = current1.next;
                    current2 = current2.next;
                }
            }
        }
        PolydataNode<String> current = current1==null?current2 : current1;
        while(current != null) {
            FormedEquation.Add(current.Coeff,current.Power);
            current = current.next;
        }
        //return FormEquation(FormedEquation);
        return FormEquation(FormedEquation);
    }
    //
    public static String Substract(String Equation1 , String Equation2) {
        //case all the same variable
        PolyDataLinkedList<String> Eqn1Data = new PolyDataLinkedList<>();
        PolyDataLinkedList<String> Eqn2Data = new PolyDataLinkedList<>();
        ExtractData(Equation1, Eqn1Data);
        ExtractData(Equation2, Eqn2Data);
        PolydataNode<String> current1 = Eqn1Data.getFirst();
        PolydataNode<String> current2 = Eqn2Data.getFirst();
        while(current2 != null) {
            if(current2.Coeff.charAt(0) == '-') {
                current2.Coeff = current2.Coeff.replace("-","");
            }else
                current2.Coeff = "-"+current2.Coeff;
            current2 = current2.next;
        }
        current2 = Eqn2Data.getFirst();
        PolyDataLinkedList<String> FormedEquation = new PolyDataLinkedList<>();
        while(current1 != null && current2 != null) {
            if(Integer.parseInt(current1.Power) > Integer.parseInt(current2.Power)) {
                FormedEquation.Add(current1.Coeff,current1.Power);
                current1 = current1.next;
            }else if(Integer.parseInt(current2.Power) > Integer.parseInt(current1.Power)) {
                FormedEquation.Add(current2.Coeff,current2.Power);
                current2 = current2.next;
            }else {
                String newCoeff = Integer.toString(Integer.parseInt(current1.Coeff)+Integer.parseInt(current2.Coeff));
                FormedEquation.Add(newCoeff,current1.Power);
                current1 = current1.next;
                current2 = current2.next;
            }
        }
        PolydataNode<String> current = current1==null?current2 : current1;
        while(current != null) {
            FormedEquation.Add(current.Coeff,current.Power);
            current = current.next;
        }
        //return FormEquation(FormedEquation);
        return FormEquation(FormedEquation);
    }

    public static void ExtractData(String Eqn , PolyDataLinkedList<String> Container){
        String Coeff = "";
        StringBuilder Power = new StringBuilder();
        int index = 0;
        int tester;
        char current;
        Eqn+="$";
        while(index < Eqn.length()) {
            current = Eqn.charAt(index);
            if(Validations.isDigit(Character.toString(current)) || (index == 0 && current == '-')) {
                Coeff+=current;
            }else if(Validations.IsPower(current)) {
                index++;
                Power.append(GetPower(index, GetNextOperatorIndex(index, Eqn), Eqn));
                index+=Power.length()-1;
            }else if(Validations.IsVar(current)) {
                if(Coeff.equals("")) {
                    Coeff = "1";
                }
                tester = index+1;
                if(!(Validations.IsPower(Eqn.charAt(tester))) || Eqn.charAt(tester)=='$') {
                    Power = new StringBuilder("1");
                }
            }else if(Validations.IsBinaryOperator(current)) {
                if(GetNextOperatorIndex(index, Eqn) == -1 && Power.toString().equals(""))
                    Power = new StringBuilder("0");
                if(Coeff.charAt(0) == '-' && Coeff.length() == 1) {
                    Coeff = "-1";
                }
                Container.Add(Coeff, Power.toString());
                Coeff = "";
                Power = new StringBuilder();
                if(current == '-' && PurePostive(Coeff)) {
                    //-1265x^65421+321x^84-w+x+y-r+10x^26+6
                    //here is the problem check above
                    // there is a shitf in sign figure it out
                    Coeff = "-"+Coeff;
                }

            }
            if(current == '$') {
                //System.out.println("coeff-> "+Coeff+"\nPower-> "+Power);
                if(GetNextOperatorIndex(index, Eqn) == -1 && Power.toString().equals(""))
                    Power = new StringBuilder("0");
                Container.Add(Coeff, Power.toString());
                Coeff = "";
                Power = new StringBuilder();
            }
            index++;
        }
        Eqn = Eqn.replace("$","");
		/*
		PolydataNode<String> currentnode1 = Container.getFirst();
		PolydataNode<String> currentnode2 = currentnode1.next;
		boolean flag = false;
		for(int i = 0; i <Container.size(); i++) {
			for(int j = 0;  j<Container.size()-1; j++) {
				if(currentnode1.next == null)
				{
					flag = true;
					break;
				}else if(currentnode2 == null)
					currentnode2 = currentnode1.next;
				if(currentnode1.Power != ""&&currentnode2.Power !=""&&Integer.parseInt(currentnode1.Power) == Integer.parseInt(currentnode2.Power)) {
					currentnode1.Coeff = Integer.toString(Integer.parseInt(currentnode1.Coeff)+Integer.parseInt(currentnode2.Coeff));
					currentnode2.Coeff = "0";
					currentnode2.Power = "0";
				}
				currentnode2 = currentnode2.next;
			}
			if(flag)
				break;
			currentnode1 = currentnode1.next;
			if(currentnode1.next == null) {
				break;
			}
		}
		*/
    }

    public static String GetPower(int start , int end , String eqn) {
        StringBuilder power = new StringBuilder();
        if(end == -1) {
            end = eqn.length();
        }
        for(int i = start ; i<end ; i++) {
            if(eqn.charAt(i) == '$')
                continue;
            power.append(eqn.charAt(i));
        }
        return power.toString();
    }
    public static int GetNextOperatorIndex(int CurrentIndex, String eqn) {
        for(int i = CurrentIndex ; i<eqn.length(); i++) {
            if(Validations.IsBinaryOperator(eqn.charAt(i)))
                return i;
        }
        return -1;
    }
    public static boolean PurePostive(String coeff) {
        for(int i = 0 ; i <coeff.length(); i++) {
            if(coeff.charAt(i) == '-')
                return false;
        }
        return true;
    }

    public static String FormEquation(PolyDataLinkedList<String> EquationData) {
        StringBuilder equation = new StringBuilder();
        PolydataNode<String> current = EquationData.getFirst();
        while(current != null) {
            if(Integer.parseInt(current.Power) == 1) {
                current.Power = "$";
            }
            current = current.next;
        }
        current = EquationData.getFirst();
        while(current != null) {
            if(current.next == null) {
                equation.append(current.Coeff).append("x").append("^").append(current.Power);
            }else
            if(Integer.parseInt(current.Coeff) != 0)
                equation.append(" ").append(current.Coeff).append("x").append("^").append(current.Power).append(" + ");
            current = current.next;
        }

        equation = new StringBuilder(equation.toString().replaceAll("\\s+", " "));
        equation = new StringBuilder(equation.toString().replace("x^0", ""));
        equation = new StringBuilder(equation.toString().replace("1x", "x"));
        equation = new StringBuilder(equation.toString().replace("-1x", "-x"));
        equation = new StringBuilder(equation.toString().replace("x^$", "x "));
        equation = new StringBuilder(equation.toString().replace("+ -", " - "));
        equation = new StringBuilder(equation.toString().replace("- -", " + "));
        equation = new StringBuilder(equation.toString().replace("^$ +", " + "));
        equation = new StringBuilder(equation.toString().replace("^$ -", " - "));
        equation = new StringBuilder(equation.toString().replaceAll("\\s+", " "));
        equation = new StringBuilder(equation.toString().trim());
        return equation.toString();

    }

    public static String SortByExponent(String equation) {
        // still working on it
        return equation;
    }
    //4x^3+6x^6+8x
    //3x^3+2x^2+x+1
}
	