package models;

import org.example.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Questions {

        List<String[]> quizQuestions;

        public List<String[]> getQuizQuestions() {
                return quizQuestions;
        }

        public void setQuizQuestions(List<String[]> quizQuestions) {
                this.quizQuestions = quizQuestions;
        }

        public Questions() {

                quizQuestions = new ArrayList<>();

                quizQuestions.add(new String[] {
                                "What is the capital of Java?", "a) Jakarta", "b) Bandung", "c) Surabaya", "d) Bali",
                                "a"
                });
                quizQuestions.add(new String[] {
                                "Which of the following is not a primitive data type in Java?", "a) int", "b) float",
                                "c) string", "d) char", "c"
                });
                quizQuestions.add(new String[] {
                                "What is the output of the expression '7 % 3' in Java?", "a) 1", "b) 2", "c) 3", "d) 4",
                                "b"
                });
                quizQuestions.add(new String[] {
                                "Which keyword is used to define a class in Java?", "a) class", "b) void", "c) public",
                                "d) private", "a"
                });
                quizQuestions.add(new String[] {
                                "What does the 'static' keyword mean in Java?",
                                "a) The variable or method belongs to the class, not instances of the class",
                                "b) The variable or method belongs to instances of the class, not the class itself",
                                "c) The variable or method is final and cannot be modified",
                                "d) The variable or method can be accessed from anywhere in the program", "a"
                });
                quizQuestions.add(new String[] {
                                "Which of the following is true about 'break' statement in Java?",
                                "a) It is used to exit from a loop",
                                "b) It is used to skip the current iteration of a loop",
                                "c) It is used to execute the next iteration of a loop",
                                "d) It is used to define a block of code", "a"
                });
                quizQuestions.add(new String[] {
                                "What is the default value of 'int' in Java?", "a) 0", "b) 0.0", "c) null",
                                "d) 'undefined'", "a"
                });
                quizQuestions.add(new String[] {
                                "What is the output of the code snippet: 'System.out.println(10 > 5 && 5 < 3);' in Java?",
                                "a) true", "b) false", "c) compilation error", "d) runtime error", "b"
                });
                quizQuestions.add(new String[] {
                                "Which of the following access modifiers restricts access the most in Java?",
                                "a) public", "b) protected", "c) private", "d) default", "c"
                });
                quizQuestions.add(new String[] {
                                "What is the purpose of 'this' keyword in Java?", "a) To refer to the superclass",
                                "b) To refer to the current class instance", "c) To refer to a static method",
                                "d) To refer to a parent class", "b"
                });
                quizQuestions.add(new String[] {
                                "What does JVM stand for in Java?", "a) Java Virtual Machine", "b) Java Vendor Machine",
                                "c) Java Variable Machine", "d) Java Visual Machine", "a"
                });
                quizQuestions.add(new String[] {
                                "Which method is called automatically when an object is created?", "a) finalize()",
                                "b) delete()", "c) main()", "d) constructor()", "d"
                });
                quizQuestions.add(new String[] {
                                "What is the output of the following code snippet? \n int x = 5; \n System.out.println(++x);",
                                "a) 5", "b) 6", "c) 4", "d) Compilation Error", "b"
                });
                quizQuestions.add(new String[] {
                                "Which of the following is a loop construct in Java?", "a) for-each", "b) for-every",
                                "c) for-all", "d) for-iterate", "a"
                });
                quizQuestions.add(new String[] {
                                "What is the result of 'true && false' in Java?", "a) true", "b) false",
                                "c) compilation error", "d) runtime error", "b"
                });
                quizQuestions.add(new String[] {
                                "Which keyword is used to create an object in Java?", "a) new", "b) create",
                                "c) instantiate", "d) object", "a"
                });
                quizQuestions.add(new String[] {
                                "What is the purpose of the 'finally' block in Java?", "a) To define the superclass",
                                "b) To execute code after try-catch blocks, regardless of an exception",
                                "c) To declare variables", "d) To refer to a static method", "b"
                });
                quizQuestions.add(new String[] {
                                "What is the output of 'System.out.println(10/3);' in Java?", "a) 3", "b) 3.333",
                                "c) 3.0", "d) Compilation Error", "a"
                });
                quizQuestions.add(new String[] {
                                "Which of the following is not a valid Java identifier?", "a) _variableName",
                                "b) $variableName", "c) 1variableName", "d) variableName", "c"
                });
                quizQuestions.add(new String[] {
                                "What is the superclass of all classes in Java?", "a) Object", "b) Class", "c) Base",
                                "d) Main", "a"
                });

        }

        public void checker(List<String[]> quizQuestions, List<String> answers, String name) throws SQLException {
                System.out.println(quizQuestions.size());
                System.out.println(answers.size());
                int correct_ans = 0;
                double sucess_rate = 0.0;
                for (int i = 0; i < quizQuestions.size(); i++) {
                        String[] question = quizQuestions.get(i);
                        String user_ans = answers.get(i);
                        if (question[5].equalsIgnoreCase(user_ans)) {
                                correct_ans++;
                        }
                }
                sucess_rate = (correct_ans * 10.0);
                Query.score(name, sucess_rate);

        }
}
