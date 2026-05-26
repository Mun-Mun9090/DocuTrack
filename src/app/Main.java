package app;

import java.util.Scanner;

import models.Document;
import modules.indexing.avl.AVLTree;
import modules.indexing.bst.BST;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BST bst = new BST();
        AVLTree avl = new AVLTree();

        int choice;

        while (true) {

            System.out.println("\n===== DOCUTRACK =====");
            System.out.println("1. Insert Document");
            System.out.println("2. Search Document");
            System.out.println("3. Delete Document (BST)");
            System.out.println("4. Display BST Inorder");
            System.out.println("5. Display AVL Inorder");
            System.out.println("6. Minimum Document");
            System.out.println("7. Maximum Document");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Document ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Document doc = new Document(id, title, author);

                    bst.insert(doc);

                    avl.root = avl.insert(avl.root, doc);

                    System.out.println("Document inserted successfully");
                    break;

                case 2:
                    System.out.print("Enter Document ID to search: ");
                    int searchId = sc.nextInt();

                    Document result = avl.search(avl.root, searchId);

                    if (result != null)
                        System.out.println(result);
                    else
                        System.out.println("Document not found");
                    break;

                case 3:

                    System.out.print("Enter Document ID to delete: ");
                    int deleteId = sc.nextInt();

                    bst.delete(deleteId);

                    break;

                case 4:

                    System.out.println("\nBST Inorder Traversal:");
                    bst.inorder(bst.root);

                    break;

                case 5:
                    System.out.println("\nAVL Inorder Traversal:");
                    avl.inorder(avl.root);
                    break;

                case 6:
                    bst.minimum();
                    break;

                case 7:
                    bst.maximum();
                    break;

                case 8:
                    System.exit(0);
                default:
                  System.out.println("Invalid choice");
            }
        }
    }
}