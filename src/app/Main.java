package app;

import java.util.Scanner;

import models.Document;
import modules.analytics.BPlusTree;
import modules.analytics.BTree;
import modules.analytics.FenwickTree;
import modules.analytics.SegmentTree;
import modules.graph.BFS;
import modules.graph.DFS;
import modules.graph.Graph;
import modules.graph.MST;
import modules.indexing.avl.AVLTree;
import modules.indexing.bst.BST;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      DOCUTRACK LOGIN");
            System.out.println("=================================");

            System.out.print("Username: ");
            String username = sc.next();

            System.out.print("Password: ");
            String password = sc.next();

            if (username.equals("admin") &&
                password.equals("admin123")) {

                System.out.println("\nWelcome Admin");
                adminMenu();

            } else if (username.equals("user") &&
                       password.equals("user123")) {

                System.out.println("\nWelcome User");
                userMenu();

            } else {

                System.out.println("Invalid Credentials");
            }
        }
    }

    // ==========================
    // ADMIN MENU
    // ==========================

    static void adminMenu() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("       DOCUTRACK SYSTEM");
            System.out.println("=================================");

            System.out.println("1. CO1 - Document Indexing");
            System.out.println("2. CO2 - Analytics");
            System.out.println("3. CO3 - Document Network");
            System.out.println("4. CO4 - Path Optimization");
            System.out.println("5. CO5 - Sorting & Ranking");
            System.out.println("6. CO6 - Storage Optimization");
            System.out.println("7. Logout");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    co1Menu();
                    break;

                case 2:
                    co2Menu();
                    break;

                case 3:
                    co3Menu();
                    break;

                case 4:
                    System.out.println("CO4 Coming Soon");
                    break;

                case 5:
                    System.out.println("CO5 Coming Soon");
                    break;

                case 6:
                    System.out.println("CO6 Coming Soon");
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // ==========================
    // USER MENU
    // ==========================

    static void userMenu() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("            USER MENU");
            System.out.println("=================================");

            System.out.println("1. Search Document");
            System.out.println("2. View Documents");
            System.out.println("3. Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Search Feature");
                    break;

                case 2:
                    System.out.println("View Documents Feature");
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // ==========================
    // CO1 MENU
    // ==========================

    static void co1Menu() {

        while(true) {

            System.out.println("\n========== CO1 ==========");
            System.out.println("1. BST Operations");
            System.out.println("2. AVL Operations");
            System.out.println("3. Back");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    bstMenu();
                    break;

                case 2:
                    avlMenu();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    // ==========================
    // CO2 MENU
    // ==========================

    static void co2Menu() {

        FenwickTree ft = new FenwickTree(10);

        int arr[] = {5,3,7,2,4,6,8};
        SegmentTree st = new SegmentTree(arr);

        BTree bt = new BTree();
        BPlusTree bpt = new BPlusTree();

        while(true) {

            System.out.println("\n========== CO2 ==========");
            System.out.println("1. Fenwick Tree");
            System.out.println("2. Segment Tree");
            System.out.println("3. B Tree");
            System.out.println("4. B+ Tree");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter Day: ");
                    int day = sc.nextInt();

                    System.out.print("Enter Access Count: ");
                    int count = sc.nextInt();

                    ft.update(day, count);

                    System.out.println(
                            "Total Accesses Till Day "
                                    + day + " = "
                                    + ft.sum(day));

                    break;

                case 2:

                    System.out.print("Enter Left Index: ");
                    int l = sc.nextInt();

                    System.out.print("Enter Right Index: ");
                    int r = sc.nextInt();

                    System.out.println(
                    	    "Range Sum = " +
                    	    st.query(
                    	        1,
                    	        0,
                    	        arr.length - 1,
                    	        l,
                    	        r
                    	    )
                    	);

                    break;

                case 3:

                    System.out.print("Enter Key: ");
                    int key = sc.nextInt();

                    bt.insert(key);

                    System.out.println("B Tree Contents:");
                    bt.display();

                    break;

                case 4:

                    System.out.print("Enter Key: ");
                    key = sc.nextInt();

                    bpt.insert(key);

                    System.out.print("Range Start: ");
                    int start = sc.nextInt();

                    System.out.print("Range End: ");
                    int end = sc.nextInt();

                    bpt.rangeSearch(start, end);

                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    static void co3Menu() {

        Graph graph =
                new Graph(5);

        while(true) {

            System.out.println(
                    "\n===== CO3 =====");

            System.out.println(
                    "1. Add Relationship");

            System.out.println(
                    "2. Display Graph");

            System.out.println(
                    "3. BFS Traversal");

            System.out.println(
                    "4. DFS Traversal");

            System.out.println(
                    "5. MST");

            System.out.println(
                    "6. Back");

            int choice =
                    sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print(
                            "Source: ");

                    int s =
                            sc.nextInt();

                    System.out.print(
                            "Destination: ");

                    int d =
                            sc.nextInt();

                    graph.addEdge(s,d);

                    break;

                case 2:

                    graph.display();

                    break;

                case 3:

                    System.out.print(
                            "Start Vertex: ");

                    int start =
                            sc.nextInt();

                    BFS.bfs(
                            graph,
                            start);

                    break;

                case 4:

                    System.out.print(
                            "Start Vertex: ");

                    start =
                            sc.nextInt();

                    boolean visited[] =
                            new boolean[5];

                    DFS.dfs(
                            graph,
                            start,
                            visited);

                    System.out.println();

                    break;

                case 5:

                    MST.displayMST();

                    break;

                case 6:

                    return;
            }
        }
    }
    static void bstMenu() {
    	
    	BST bst = new BST();

        while(true) {

            System.out.println("\n====== BST ======");
            System.out.println("1. Insert Document");
            System.out.println("2. Search Document");
            System.out.println("3. Delete Document");
            System.out.println("4. Display Inorder");
            System.out.println("5. Minimum");
            System.out.println("6. Maximum");
            System.out.println("7. Back");

            int ch = sc.nextInt();

            switch(ch) {

                case 1:

                    System.out.print("Document ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    Document doc =
                            new Document(
                                    id,
                                    title,
                                    author);

                    bst.insert(doc);

                    System.out.println("Inserted Successfully");

                    break;

                case 2:

                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    Document result =
                            bst.search(id);

                    if(result != null)
                        System.out.println(result);
                    else
                        System.out.println("Not Found");

                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    bst.delete(id);

                    break;

                case 4:

                    bst.inorder(bst.root);

                    break;

                case 5:

                    bst.minimum();

                    break;

                case 6:

                    bst.maximum();

                    break;

                case 7:

                    return;
            }
        }
    }
    static void avlMenu() {
    	
    	AVLTree avl = new AVLTree();

        while(true) {

            System.out.println("\n====== AVL ======");
            System.out.println("1. Insert Document");
            System.out.println("2. Search Document");
            System.out.println("3. Display Inorder");
            System.out.println("4. Back");

            int ch = sc.nextInt();

            switch(ch) {

                case 1:

                    System.out.print("Document ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    Document doc =
                            new Document(
                                    id,
                                    title,
                                    author);

                    avl.root =
                            avl.insert(
                                    avl.root,
                                    doc);

                    System.out.println("Inserted Successfully");

                    break;

                case 2:

                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    Document result =
                            avl.search(
                                    avl.root,
                                    id);

                    if(result != null)
                        System.out.println(result);
                    else
                        System.out.println("Not Found");

                    break;

                case 3:

                    avl.inorder(avl.root);

                    break;

                case 4:

                    return;
            }
        }
    }
    
}
