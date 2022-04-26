import java.util.*;

public class Assembly {

    private final ArrayList<String> asm = new ArrayList<>();
    private int register_counter = 0;

    public Assembly() {}


    public void createAssembly(ScopeNode scope_node) {
        ArrayList<String> printed_code = new ArrayList<String>();
        asm.add(";tiny code");
        asm.addAll(processTree(scope_node, new ArrayList<>()));
//        asm.add("yolo :)");
//        System.out.println();

        for (int index = 0; index < asm.size(); index++) {
            if (printed_code.contains(asm.get(index))) {
                continue;
            } else {
                printed_code.add(asm.get(index));
            }


            System.out.println(asm.get(index));
        }// end for loop

        asm.add("sys halt");
        System.out.println(asm.get(asm.size() - 1));
    }// createAssembly()


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

        // ADD operation
        if (binary_node.getElement().equals("+")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            ArrayList<String> left = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            for (int i = 0; i < oldStrings.size(); i++) {
                right.remove(0);
                left.remove(0);
            }

            String leftside = left.get(0);
            String[] lsplit = leftside.split(":");
            String type = lsplit[0];

            String[] assignVars = new String[right.size()];
            for (int i = 0; i < assignVars.length; i++) {
                assignVars[i] = right.get(i).split(":")[1];
            }
            if (assignVars.length <= 2) {
                if (type.equals("INT")) {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("addi " + assignVars[1] + " r" + register_counter);
                }
                else {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("addr " + assignVars[1] + " r" + register_counter);
                }
            }
            register_counter++;
            return tree_strings;
        }
        if (binary_node.getElement().equals("-")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            ArrayList<String> left = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            for (int i = 0; i < oldStrings.size(); i++) {
                right.remove(0);
                left.remove(0);
            }

            String leftside = left.get(0);
            String[] lsplit = leftside.split(":");
            String type = lsplit[0];

            String[] assignVars = new String[right.size()];
            for (int i = 0; i < assignVars.length; i++) {
                assignVars[i] = right.get(i).split(":")[1];
            }
            if (assignVars.length <= 2) {
                if (type.equals("INT")) {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("subi " + assignVars[1] + " r" + register_counter);
                }
                else {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("subr " + assignVars[1] + " r" + register_counter);
                }
            }
            register_counter++;
            return tree_strings;
        }
        if (binary_node.getElement().equals("*")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            ArrayList<String> left = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            for (int i = 0; i < oldStrings.size(); i++) {
                right.remove(0);
                left.remove(0);
            }

            String leftside = left.get(0);
            String[] lsplit = leftside.split(":");
            String type = lsplit[0];

            String[] assignVars = new String[right.size()];
            for (int i = 0; i < assignVars.length; i++) {
                assignVars[i] = right.get(i).split(":")[1];
            }
            if (assignVars.length <= 2) {
                if (type.equals("INT")) {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("muli " + assignVars[1] + " r" + register_counter);
                }
                else {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("mulr " + assignVars[1] + " r" + register_counter);
                }
            }
            register_counter++;
            return tree_strings;
        }
        if (binary_node.getElement().equals("/")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            ArrayList<String> left = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            for (int i = 0; i < oldStrings.size(); i++) {
                right.remove(0);
                left.remove(0);
            }

            String leftside = left.get(0);
            String[] lsplit = leftside.split(":");
            String type = lsplit[0];

            String[] assignVars = new String[right.size()];
            for (int i = 0; i < assignVars.length; i++) {
                assignVars[i] = right.get(i).split(":")[1];
            }
            if (assignVars.length <= 2) {
                if (type.equals("INT")) {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("divi " + assignVars[1] + " r" + register_counter);
                }
                else {
                    tree_strings.add("move " + assignVars[0] + " r" + register_counter);
                    tree_strings.add("divr " + assignVars[1] + " r" + register_counter);
                }
            }
            register_counter++;
            return tree_strings;
        }
        // assignment
        if (binary_node.getElement().equals("assign_expr")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            processBinaryTree(binary_node.getLeftChild(), tree_strings); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            if (oldStrings.size() > 0) {
                right.subList(0, oldStrings.size()).clear();
            }


            boolean flag = false;
            String[] assignVars = new String[right.size()];

            for (int i = 0; i < assignVars.length; i++) {
                if (right.get(i).split(":").length > 1) {
                    assignVars[i] = right.get(i).split(":")[1];
                }
                else {
                    flag = true;
                    break;
                }
            }

            String tempa = tree_strings.remove(tree_strings.size() - 1);
            String tempb = tree_strings.remove(tree_strings.size() - 1);

            if (assignVars.length <= 2) {
                tree_strings.add("move " + assignVars[1] + " " + "r" + register_counter);
                tree_strings.add("move r" + register_counter + " " + assignVars[0]);
            }
            if (flag) {
                tree_strings.remove(tree_strings.size() - 1);
                tree_strings.remove(tree_strings.size() - 1);
                tree_strings.remove(tree_strings.size() - 1);
                tree_strings.add(tempb);
                tree_strings.add(tempa);
                tree_strings.add("move r" + --register_counter + " " + assignVars[0]);
            }

            register_counter++;
            return tree_strings;
        }

        if (binary_node.getElement().equals("var_decl")) {
            processBinaryTree(binary_node.getLeftChild(), tree_strings);
            processBinaryTree(binary_node.getRightChild(), tree_strings);
            return tree_strings;
        }
        if (binary_node.getElement().equals("id_tail")) {
            processBinaryTree(binary_node.getLeftChild(), tree_strings);
            processBinaryTree(binary_node.getRightChild(), tree_strings);
            return tree_strings;
        }
        if (binary_node.getElement().equals("READ")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            ArrayList<String> left = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            for (int i = 0; i < oldStrings.size(); i++) {
                right.remove(0);
                left.remove(0);
            }

            String leftside = left.get(0);
            String[] lsplit = leftside.split(":");
            String type = lsplit[0];

            String[] assignVars = new String[right.size()];
            for (int i = 0; i < assignVars.length; i++) {
                assignVars[i] = right.get(i).split(":")[1];
            }

            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.remove(tree_strings.size() - 1);

            for (String var: assignVars) {
                if (type.equals("INT")) {
                    tree_strings.add("sys readi " + var);
                }
                else {
                    tree_strings.add("sys readr " + var);
                }
            }

            return tree_strings;
        }
        if (binary_node.getElement().equals("WRITE")) {
            ArrayList<String> oldStrings = new ArrayList<>(tree_strings);
            ArrayList<String> left = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
            ArrayList<String> right = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

            if (right.size() == 0) {
                String leftside = left.get(left.size() - 1);
                String[] lsplit = leftside.split(":");
                String type = lsplit[0];
                String var = lsplit[1];

                tree_strings.remove(tree_strings.size() - 1);

                if (type.equals("INT")) {
                    tree_strings.add("sys writei " + var);
                } else if (type.equals("FLOAT")) {
                    tree_strings.add("sys writer " + var);
                } else {
                    tree_strings.add("sys writes " + var);
                }

            }

            else {
                for (int i = 0; i < oldStrings.size(); i++) {
                    right.remove(0);
                    left.remove(0);
                }

                String[] assignVars = new String[right.size()];
                String[] varTypes = new String[right.size()];
                for (int i = 0; i < assignVars.length; i++) {
                    varTypes[i] = right.get(i).split(":")[0];
                    assignVars[i] = right.get(i).split(":")[1];
                }

                for (int i = 0; i < assignVars.length; i++) {
                    tree_strings.remove(tree_strings.size() - 1);
                }

                for (int i = 0; i < assignVars.length; i++) {
                    if (varTypes[i].equals("INT")) {
                        tree_strings.add("sys writei " + assignVars[i]);
                    } else if (varTypes[i].equals("FLOAT")) {
                        tree_strings.add("sys writer " + assignVars[i]);
                    } else {
                        tree_strings.add("sys writes " + assignVars[i]);
                    }
                }
            }


            return tree_strings;
        }


//        switch (binary_node.getElement()) {
//            case "+":
//                operation = "addr ";
//                int_operation = "addi ";
//                register_counter++;
//                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);
//
//            case "-":
//                operation = "subr ";
//                int_operation = "subi ";
//                register_counter++;
//                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);
//
//            case "*":
//                operation = "mulr ";
//                int_operation = "muli ";
//                register_counter++;
//                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);
//
//            case "/":
//                operation = "divr ";
//                int_operation = "divi ";
//                register_counter++;
//                return math_operation(int_operation, operation, tree_strings, binary_node, register_counter);
//
//            case "assign_expr":
//                register_counter++;
//                return assign_expr(tree_strings, binary_node);
//
//            case "var_decl":
//            case "id_tail":
//                processBinaryTree(binary_node.getLeftChild(), tree_strings);
//                processBinaryTree(binary_node.getRightChild(), tree_strings);
//                break;
//
//            case "READ":
//                return READ_statement(tree_strings, binary_node);
//
//            case "WRITE":
//                return WRITE_statement(tree_strings, binary_node);
//
//            default:
//                break;
//        }// end switch statement


        return tree_strings;
    }// end processBinaryTree()


    private ArrayList<String> math_operation(String int_operation, String operation, ArrayList<String> tree_strings,
                                             BNode binary_node, int register_counter) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        ArrayList<String> left_child = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

        for (int index = 0; index < old.size(); index++) {
            right_child.remove(0);
            left_child.remove(0);
        }// end for loop

        String left_side = left_child.get(0);
        String[] left_side_split = left_side.split(":");
        String type = left_side_split[0];
        String[] assign_variables = new String[right_child.size()];

        for (int index = 0; index < assign_variables.length; index++) {
            assign_variables[index] = right_child.get(index).split(":")[1];
        }// end for loop

        if (assign_variables.length < 3) {
            if (type.equals("INT")) {
                tree_strings.add("move " + assign_variables[0] + " r" + register_counter);
                tree_strings.add(int_operation + assign_variables[1] + " r" + register_counter);
            } else {
                tree_strings.add("move " + assign_variables[0] + " r" + register_counter);
                tree_strings.add(operation + assign_variables[1] + " r" + register_counter);
            }// end inner if / else statement
        }// end inner if statement

        return tree_strings;
    }// end math_operations()


    private ArrayList<String> assign_expr(ArrayList<String> tree_strings, BNode binary_node) {
        boolean flag = false;
        ArrayList<String> old = new ArrayList<>(tree_strings);
        processBinaryTree(binary_node.getLeftChild(), tree_strings); //left should always have size() == 1
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

        if (old.size() > 0) {
            right_child.subList(0, old.size()).clear();
        }// end inner if statement


        String[] assign_variables = new String[right_child.size()];

        for (int index = 0; index  < assign_variables.length; index++) {
            if (right_child.get(index).split(":").length > 1) {
                assign_variables[index] = right_child.get(index).split(":")[1];
            } else {
                flag = true;
                break;
            }// end if / else statements
        }// end for loop

        String temp = tree_strings.remove(tree_strings.size() - 1);

        if (assign_variables.length < 3) {
            tree_strings.add("move " + assign_variables[1] + " " + "r" + register_counter);
            tree_strings.add("move r" + register_counter + " " + assign_variables[0]);
        }

        if (flag) {
            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.remove(tree_strings.size() - 1);
            tree_strings.add(temp);
            tree_strings.add(temp);
            tree_strings.add("move r" + --register_counter + " " + assign_variables[0]);
        }

        return tree_strings;
    }// end assign_expr()


    private ArrayList<String> READ_statement(ArrayList<String> tree_strings, BNode binary_node) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        ArrayList<String> left_child = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));
        for (int index = 0; index < old.size(); index++) {
            right_child.remove(0);
            left_child.remove(0);
        }// end for loop

        String left_side = left_child.get(0);
        String[] left_side_split = left_side.split(":");
        String type = left_side_split[0];
        String[] assign_variables = new String[right_child.size()];

        for (int index = 0; index < assign_variables.length; index++) {
            assign_variables[index] = right_child.get(index).split(":")[1];
        }// end for loop

        tree_strings.remove(tree_strings.size() - 1);
        tree_strings.remove(tree_strings.size() - 1);

        for (String variable: assign_variables) {
            if (type.equals("INT")) {
                tree_strings.add("sys readi " + variable);
            } else {
                tree_strings.add("sys readr " + variable);
            }
        }

        return tree_strings;
    }// end READ_statement()

    private ArrayList<String> WRITE_statement(ArrayList<String> tree_strings, BNode binary_node) {
        ArrayList<String> old = new ArrayList<>(tree_strings);
        ArrayList<String> left_child = new ArrayList<>(processBinaryTree(binary_node.getLeftChild(), tree_strings)); //left should always have size() == 1
        ArrayList<String> right_child = new ArrayList<>(processBinaryTree(binary_node.getRightChild(), tree_strings));

        if (right_child.size() == 0) {
            String left_side = left_child.get(0);
            String[] left_side_split = left_side.split(":");
            String type = left_side_split[0];
            String variable = left_side_split[1];

            tree_strings.remove(tree_strings.size() - 1);

            if (type.equals("INT")) {
                tree_strings.add(("sys writei " + variable));
            } else if (type.equals("FLOAT")) {
                tree_strings.add("sys writer " + variable);
            } else {
                tree_strings.add("sys writes " + variable);
            }
        } else {
            for (int index = 0; index < old.size(); index++) {
                right_child.remove(0);
                left_child.remove(0);
            }// end for loop

            String[] assign_variables = new String[right_child.size()];
            String[] variable_types = new String[right_child.size()];

            for (int index  = 0; index < assign_variables.length; index++) {
                variable_types[index] = right_child.get(index).split(":")[0];
                assign_variables[index] = right_child.get(index).split(":")[1];
            }

            for (int index = 0; index < assign_variables.length; index++) {
                tree_strings.remove(tree_strings.size() - 1);
            }// end for loop

            for (int index = 0; index < assign_variables.length; index++) {
                if (variable_types[index].equals("INT")) {
                    tree_strings.add(("sys writei " + assign_variables[index]));
                } else if (variable_types[index].equals("FLOAT")) {
                    tree_strings.add("sys writer " + assign_variables[index]);
                } else {
                    tree_strings.add("sys writes " + assign_variables[index]);
                }// end else if statements
            }// end for loop
        }// end inner if / else statement

        return tree_strings;
    }// end WRITE_statement()


}// end Assembly class
