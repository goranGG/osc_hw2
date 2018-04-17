package mainPkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    static private List<News> newsList = new ArrayList<>();
    static private List<Author> authorList = new ArrayList<>();
    static private List<Category> categoryList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int mainMenu;

        do {
            System.out.println("1.create 2.read 3.update 4.delete 5.exit");
            mainMenu = scanner.nextInt();
            if (mainMenu == 1) {
                create();
            } else if (mainMenu == 2) {
                read(0);
            } else if (mainMenu == 3) {
                update();
            } else if (mainMenu == 4) {
                delete();
            }
        } while (mainMenu != 5);
    }

    private static void create() {
        Scanner scanner = new Scanner(System.in);
        int createMenu;
        int nextID;

        do {
            System.out.println("\nCreate new... 1.News 2.Category 3.Author 4.exit");
            createMenu = scanner.nextInt();

            if (createMenu == 1) {
                System.out.println("enter news title");
                String newsTitle = scanner.next();
                getAllAuthors();
                System.out.println("author ID");
                int authorID = scanner.nextInt();
                getAllCategories();
                System.out.println("category ID");
                int categoryID = scanner.nextInt();

                if (newsList.isEmpty()) {
                    nextID = 0;
                } else {
                    int last = newsList.size();
                    News temp = newsList.get(last - 1);
                    nextID = temp.getId() + 1;
                }
                News category = new News(nextID, newsTitle, authorID, categoryID);
                newsList.add(category);

            } else if (createMenu == 2) {

                System.out.println("enter category name");
                String categoryName = scanner.next();

                if (categoryList.isEmpty()) {
                    nextID = 0;
                } else {
                    int last = categoryList.size();
                    Category temp = categoryList.get(last - 1);
                    nextID = temp.getId() + 1;
                }
                Category category = new Category(nextID, categoryName);
                categoryList.add(category);
            } else if (createMenu == 3) {
                System.out.println("enter first name");
                String firstName = scanner.next();

                System.out.println("enter last name");
                String lastName = scanner.next();

                if (authorList.isEmpty()) {
                    nextID = 0;
                } else {
                    int last = authorList.size();
                    Author temp = authorList.get(last - 1);
                    nextID = temp.getId() + 1;
                }

                Author author = new Author(nextID, firstName, lastName);

                authorList.add(author);
            }
        } while (createMenu != 4);
    }

    private static void read(int input) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nReading.... 1.News 2.Category 3.Author 4.exit");
            if (input == 0) {
                input = scanner.nextInt();
            }
            if (input == 1) {
                getAllNews();

            } else if (input == 2) {
                getAllCategories();
                System.out.println("Do you want to see article for category?");
                // @TODO if yes then enter ID
            } else if (input == 3) {
                getAllAuthors();
                System.out.println("Do you want to see someones article?");
                // @TODO if yes then enter ID

            }
            // if not ask for input again
            if (input != 4) {
                input = 0;
            }
        } while (input != 4);


    }

    private static void update() {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("\nUpdating.... 1.News 2.Category 3.Author 4.exit");
            input = scanner.nextInt();

            if (input == 1) {
                getAllNews();
                // prompt enter ID to change
                System.out.println("Enter ID that you want to update");
                int id = scanner.nextInt();
                int updateID = -1;
                for (News news : newsList) {
                    if (news.getId() == id) {
                        updateID = newsList.indexOf(news);
                    }
                }
                if (updateID != -1) {
                    System.out.println("what do you want to update");
                    System.out.println("1.Title 2.Category 3.Author");
                    int option = scanner.nextInt();
                    News updating = newsList.get(updateID);

                    if (option == 1) {
                        System.out.println("Enter new title");
                        String newsTitle = scanner.next();
                        updating.setTitle(newsTitle);
                    }
                    else if (option == 2){
                        getAllCategories();
                        System.out.println("Enter category");
                        int newsCategoryID = scanner.nextInt();
                        updating.setCategoryID(newsCategoryID);
                    }
                    else if (option == 3){
                        getAllAuthors();
                        System.out.println("Enter new author ID");
                        int newsCategoryID = scanner.nextInt();
                        updating.setCategoryID(newsCategoryID);
                    }
                }
            }
            // edit CATEGORIES
            else if (input == 2) {
                // show categories
                getAllCategories();
                // prompt enter ID to change
                System.out.println("Enter ID that you want to update");
                int id = scanner.nextInt();
                int updateID = -1;
                for (Category category : categoryList) {
                    if (category.getId() == id) {
                        updateID = categoryList.indexOf(category);
                    }
                }
                if (updateID != -1) {
                    System.out.println("what do you want to update");
                    System.out.println("1.Categroy name");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        Category updating = categoryList.get(updateID);
                        System.out.println("Enter new name");
                        String categoryName = scanner.next();
                        updating.setCategoryName(categoryName);
                    }
                }
            } else if (input == 3) {
                // edit authors
                getAllAuthors();
                // prompt enter ID to change
                System.out.println("Enter ID that you want to update");
                int id = scanner.nextInt();
                int updateID = -1;
                for (Author author : authorList) {
                    if (author.getId() == id) {
                        updateID = authorList.indexOf(author);
                    }
                }
                if (updateID != -1) {
                    System.out.println("what do you want to update");
                    System.out.println("1.First name 2.Last name");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        Author updating = authorList.get(updateID);
                        System.out.println("Enter new name");
                        String fistName = scanner.next();
                        updating.setFirstName(fistName);
                    }
                    if (option == 2) {
                        Author updating = authorList.get(updateID);
                        System.out.println("Enter new last name");
                        String lastName = scanner.next();
                        updating.setLastName(lastName);
                    }
                }
            }
        } while (input != 4);

    }

    private static void delete() {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("\nDelete.... 1.News 2.Category 3.Author 4.exit");
            input = scanner.nextInt();

            if (input == 1) {
                getAllNews();
                System.out.println("Enter ID that you want to delete");
                int id = scanner.nextInt();
                int removeID = -1;
                for (News news : newsList) {
                    if (news.getId() == id) {
                        removeID = newsList.indexOf(news);
                    }
                }
                if (removeID != -1) {
                    newsList.remove(removeID);
                }
            } else if (input == 2) {
                // list all categories
                getAllCategories();
                // prompt to delete (ID)
                System.out.println("Enter ID that you want to delete");
                int id = scanner.nextInt();
                int removeID = -1;
                for (Category category : categoryList) {
                    if (category.getId() == id) {
                        removeID = categoryList.indexOf(category);
                    }
                }
                if (removeID != -1) {
                    categoryList.remove(removeID);
                }
            } else if (input == 3) {
                // list all authors
                getAllAuthors();
                // prompt to delete (ID)
                System.out.println("Enter ID that you want to delete");
                int id = scanner.nextInt();
                int removeID = -1;
                for (Author author : authorList) {
                    if (author.getId() == id) {
                        removeID = authorList.indexOf(author);
                    }
                }
                if (removeID != -1) {
                    authorList.remove(removeID);
                }
            }
        } while (input != 4);

    }

    private static void getAllAuthors() {
        for (Author author : authorList) {
            System.out.println("ID:" + author.getId() + "\nFirst name:" + author.getFirstName() + "\nLast name: " + author.getLastName() + "\n-----");
        }
    }

    private static void getAllCategories() {
        for (Category category : categoryList) {
            System.out.println("ID:" + category.getId() + "\nCategory name:" + category.getCategoryName() + "\n-----");
        }
    }

    private static void getAllNews() {
        for (News news : newsList) {
            // get ID, title
            System.out.println("ID:" + news.getId() + "\nNews name:" + news.getTitle());
            // foreach category print name instead ID
            for (Category category: categoryList) {
                if (category.getId() == news.getCategoryID()){
                    System.out.println(" Category: " + category.getCategoryName());
                }
            }
            for (Author author: authorList) {
                if (author.getId() == news.getCategoryID()){
                    System.out.println(" Author: " + author.getFirstName()+" "+author.getLastName());
                    break;
                }
            }
        }
    }


}
