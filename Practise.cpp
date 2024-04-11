#include<bits/stdc++.h>
using namespace std;
struct Node{
    char data;
    Node* left;
    Node* right;
};
class Binary_tree{
    Node* head;
public:
    Binary_tree();
    void Traverse();
    int Depth();
    int Node_num();
    int Leaf_node();
    int Node_num(int degree);
};
int main(){

    return 0;
}
Binary_tree::Binary_tree() {
    head = new Node;
    cout << "请输入节点内容及孩子数" << endl;

}
