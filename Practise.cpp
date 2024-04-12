#include<bits/stdc++.h>
#include<conio.h>
using namespace std;
struct Node{
    int data;
    Node* left= nullptr;
    Node* right=nullptr;
};
class Binary_tree{
    Node* head;
public:
    Binary_tree();
    Node* Get_head();
    void Front_Traverse(Node* current);
    void Mid_Traverse(Node* current);
    void End_Traverse(Node* current);
    void Level_Traverse(Node* current);
    int Depth(Node* current);
    int Node_num(Node* current);
    int Leaf_node(Node* current);
    int DegreeNode_num(int x,Node* current);
    int Degree2(Node* current);
};

int main(){
    Binary_tree tree;

    cout<<tree.Degree2(tree.Get_head());
    system("pause");
    return 0;
}

Binary_tree::Binary_tree() {
    stack<pair<Node*,int>> order;
    head = new Node;
    Node* current=head;
    int n, k=0;
    int i=0;
   while(i<=k) {
       cout << "Please enter the node content and the number of children" << endl;
       cin >> n;
//       if(n=='N') {system("cls");return;}
       cin >> k;system("cls");
       current->data = n;
       i++;
       order.emplace(current, i);
     if(k==2){
          current->left=new Node;
          current=current->left;
          i=0;
        }
     else if(k==1){
         cout<<"Determine whether it is a left or right subtree"<<endl;
         string subtree;
         cin>>subtree;system("cls");
          if(subtree=="right"){
              current->right=new Node;
              current=current->right;
              order.pop();
              i=0;
          }
          else {
              current->left=new Node;
              current=current->left;
              order.pop();
              i=0;
          }
     }
     else {
         order.pop();
         if(!order.empty()){
         current=order.top().first;
         order.pop();
         current->right=new Node;
         current=current->right;
         i=0;
         }
         else break;
     }
   }
}
Node* Binary_tree::Get_head(){return head;}
void Binary_tree::Front_Traverse(Node* current) {
    if (current) {
        cout<<current->data;
        Front_Traverse(current->left);
        Front_Traverse(current->right);
    }
}
void Binary_tree::Mid_Traverse(Node* current) {
    if (current) {
        Mid_Traverse(current->left);
        cout<<current->data;
        Mid_Traverse(current->right);
    }
}
void Binary_tree::End_Traverse(Node* current){
    if (current) {
        End_Traverse(current->left);
        End_Traverse(current->right);
        cout<<current->data;
    }
}
void Binary_tree::Level_Traverse(Node* current){
    queue<Node*> order;
    if(current) {
        order.emplace(current);
        while (!order.empty()) {
            cout <<order.front()->data;
            if (order.front()->left) order.emplace(order.front()->left);
            if (order.front()->right) order.emplace(order.front()->right);
            order.pop();
        }
    }
}
int Binary_tree::Depth(Node* current){
    if(current){
        int i=Depth(current->left);
        int j= Depth(current->right);
        return (i>j)?i+1:j+1;
    }
    else return 0;
}
int Binary_tree::Node_num(Node* current){
    if (current) {
        return Node_num(current->left)+Node_num(current->right)+1;
    }
    else return 0;
}
int Binary_tree::Leaf_node(Node* current){
    queue<Node*> order;
    int num=0;
    if(current) {
        order.emplace(current);
        while (!order.empty()) {
            int i=0;
            if (order.front()->left) order.emplace(order.front()->left);
            else i++;
            if (order.front()->right) order.emplace(order.front()->right);
            else i++;
            if(i==2) num++;
            order.pop();
        }
        return num;
    }
}
int Binary_tree::DegreeNode_num(int x,Node* current){
    queue<Node*> order;
    int num=0;
    if(current) {
        order.emplace(current);
        while (!order.empty()) {
            if(order.front()->data>x) num++;
            if (order.front()->left) order.emplace(order.front()->left);
            if (order.front()->right) order.emplace(order.front()->right);
            order.pop();
        }
        return num;
    }
    else return 0;
}
int Binary_tree::Degree2(Node* current){
    return Leaf_node(current)-1;
}