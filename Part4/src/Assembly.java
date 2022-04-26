import java.util.*;

public class Assembly {

    private final ArrayList<String> asm = new ArrayList<>();
    private int register_counter = 0;       // counter for amount of registers being used

    public Assembly() {}

    // Creating Assembly code to be printed to user
    public void createAssembly(ScopeNode scope_node) {
        ArrayList<String> printed_code = new ArrayList<String>();
        asm.add(";tiny code");
        asm.addAll(processTree(scope_node, new ArrayList<>()));

        for (int index = 0; index < asm.size(); index++) {
            if (printed_code.contains(asm.get(index))) {
                continue;
            } else {
                printed_code.add(asm.get(index));
            }// end if / else statement

            System.out.println(asm.get(index));
        }// end for loop

        asm.add("sys halt");
        System.out.println(asm.get(asm.size() - 1));
    }// createAssembly()


    // Breaking down tree into smaller trees
    private ArrayList<String> processTree(ScopeNode scope_node, ArrayList<String> tree_strings) {
        for (int index = 0; index < scope_node.children_length(); index++) {
            if (scope_node.getChild(index) instanceof BNode) {
                tree_strings = processBinaryTree((BNode) scope_node.getChild(index), tree_strings);
            } else {
                ArrayList<String> scope_node_strings = processTree((ScopeNode) scope_node.getChild(index), tree_strings);
                tree_strings.addAll(scope_node_strings);
            }// end if / else statement
        }// end for loop

        return tree_strings;
    }// end processTree()


    // Taking smaller trees and converting their info to Tiny code
    private ArrayList<String> processBinaryTree(BNode binary_node, ArrayList<String> tree_strings) {
        String operation;
        String int_operation;

        if (binary_node.isLeaf()) {
            if (binary_node.getElement().equals("")) {
                return new ArrayList<>();
            }// end if statement

            String element = binary_node.getElement();
            String[] split_string = element.split(" ");

            if (split_string.length > 1) {
                if (tree_strings.contains("var " + split_string[1]) || tree_strings.contains("str " + split_string[1] + " " + split_string[2])) {
                    element = split_string[0] + ":" + split_string[1];
                } else if (split_string[0].equals("STRING")) {
                    element = "str " + split_string[1] + " " + split_string[2];
                } else {
                    element = "var " + split_string[1];
                }// end if / else if / else statement
            } else {
                element = split_string[0];
            }// end if / else statement

            tree_strings.add(element);
            return tree_strings;
        }// end if statement


        switch (binary_node.getElement()) {
            case "+":
                operation = "addr ";
                int_operation = "addi ";
                register_counter++;
                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);

            case "-":
                operation = "subr ";
                int_operation = "subi ";
                register_counter++;
                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);

            case "*":
                operation = "mulr ";
                int_operation = "muli ";
                register_counter++;
                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);

            case "/":
                operation = "divr ";
                int_operation = "divi ";
                register_counter++;
                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);

            case "assign_expr":
                register_counter++;
                return assign_expr(tree_strings, binary_node);

            case "var_decl":
            case "id_tail":
                processBinaryTree(binary_node.getLeftChild(), tree_strings);
                processBinaryTree(binary_node.getRightChild(), tree_strings);
                break;

            case "READ":
                return READ_statement(tree_strings, binary_node);

            case "WRITE":
                return WRITE_statement(tree_strings, binary_node);

            default:
                break;
        }// end switch statement


        return tree_strings;
    }// end processBinaryTree()


    // Math operations for tiny code
    private ArrayList<String> math_operation(String int_operation, String operation, ArrayList<String> tree_strings,
                                             BNode binary_node, int register_counter) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        ArrayList<String> left_child = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings));
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

        for (int index = 0; index < old.size(); index++) {
            right_child.remove(0);
            left_child.remove(0);
        }// end for loop

        String left_side = left_child.get(0);
        String[] left_side_split = left_side.split(":");
        String type = left_side_split[0];
        String[] assign_variable = new String[right_child.size()];

        for (int index = 0; index < assign_variable.length; index++) {
            assign_variable[index] = right_child.get(index).split(":")[1];
        }// end for loop
        if (assign_variable.length < 3) {
            if (type.equals("INT")) {
                tree_strings.add("move " + assign_variable[0] + " r" + register_counter);
                tree_strings.add(int_operation + assign_variable[1] + " r" + register_counter);
            } else {
                tree_strings.add("move " + assign_variable[0] + " r" + register_counter);
                tree_strings.add(operation + assign_variable[1] + " r" + register_counter);
            }// end if / else statement
        }// end if statement

        return tree_strings;
    }// end math_operations()

    private ArrayList<String> assign_expr(ArrayList<String> tree_strings, BNode binary_node) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        processBinaryTree(binary_node.getLeftChild(), tree_strings);
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));
        boolean flag = false;

        if (old.size() > 0) {
            right_child.subList(0, old.size()).clear();
        }// end if statement



        String[] assign_variables = new String[right_child.size()];

        for (int index = 0; index < assign_variables.length; index++) {
            if (right_child.get(index).split(":").length > 1) {
                assign_variables[index] = right_child.get(index).split(":")[1];
            } else {
                flag = true;
                break;
            }// end if / else statement
        }// end for loop

        String temp = tree_strings.remove(tree_strings.size() - 1);
        String temp_2 = tree_strings.remove(tree_strings.size() - 1);

        if (assign_variables.length < 3) {
            tree_strings.add("move " + assign_variables[1] + " " + "r" + register_counter);
            tree_strings.add("move r" + register_counter + " " + assign_variables[0]);
        }
        if (flag) {
            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.add(temp_2);
            tree_strings.add(temp);
            tree_strings.add("move r" + --register_counter + " " + assign_variables[0]);
        }

        return tree_strings;
    }// end assign_expr()

    private ArrayList<String> READ_statement(ArrayList<String> tree_strings, BNode binary_node) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        ArrayList<String> left_child = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings));
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

        for (int index = 0; index < old.size(); index++) {
            right_child.remove(0);
            left_child.remove(0);
        }// end for loop

        String left_side = left_child.get(0);
        String[] left_side_split = left_side.split(":");
        String type = left_side_split[0];

        String[] assign_variable = new String[right_child.size()];
        for (int index = 0; index < assign_variable.length; index++) {
            assign_variable[index] = right_child.get(index).split(":")[1];
        }// end for loop

        tree_strings.remove(tree_strings.size() - 1);
        tree_strings.remove(tree_strings.size() - 1);

        for (String var: assign_variable) {
            if (type.equals("INT")) {
                tree_strings.add("sys readi " + var);
            } else {
                tree_strings.add("sys readr " + var);
            }// end if / else statement
        }// end for loop

        return tree_strings;
    }// end READ_statement()

    private ArrayList<String> WRITE_statement(ArrayList<String> tree_strings, BNode binary_node) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        ArrayList<String> left_child = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings));
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

        if (right_child.size() == 0) {
            String left_side = left_child.get(left_child.size() - 1);
            String[] left_side_split = left_side.split(":");
            String type = left_side_split[0];
            String variable = left_side_split[1];

            tree_strings.remove(tree_strings.size() - 1);

            if (type.equals("INT")) {
                tree_strings.add("sys writei " + variable);
            } else if (type.equals("FLOAT")) {
                tree_strings.add("sys writer " + variable);
            } else {
                tree_strings.add("sys writes " + variable);
            }// end if / else if / else statement

        } else {
            for (int index = 0; index < old.size(); index++) {
                right_child.remove(0);
                left_child.remove(0);
            }// end for loop

            String[] assign_variables = new String[right_child.size()];
            String[] variable_types = new String[right_child.size()];

            for (int index = 0; index < assign_variables.length; index++) {
                variable_types[index] = right_child.get(index).split(":")[0];
                assign_variables[index] = right_child.get(index).split(":")[1];
            }// end for loop

            for (int index = 0; index < assign_variables.length; index++) {
                tree_strings.remove(tree_strings.size() - 1);
            }// end for loop

            for (int i = 0; i < assign_variables.length; i++) {
                if (variable_types[i].equals("INT")) {
                    tree_strings.add("sys writei " + assign_variables[i]);
                } else if (variable_types[i].equals("FLOAT")) {
                    tree_strings.add("sys writer " + assign_variables[i]);
                } else {
                    tree_strings.add("sys writes " + assign_variables[i]);
                }// end if / else if / else statements
            }// end for loop
        }// end if / else statement


        return tree_strings;

    }// end WRITE_statement()
}// end Assembly class
