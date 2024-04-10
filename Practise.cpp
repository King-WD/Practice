#include <bits/stdc++.h>
using namespace std;
struct Node{
    int data;
    Node* next;
};
Node* find(Node* front,int k){
    bool end=false;
    Node* tem=front;
    while(!end){
        if(tem->data==k)return tem;
        else {
            if(tem->next!=front)
            tem=tem->next;
            else {end=true;}
        }
    }
    return NULL;
}
int size(Node* front){
    int size=0;
    Node* tem=front;
    do{
        size++;
        tem=tem->next;
    }
    while(tem!=front);
    return size;
}
int main(){
    int n;
    cin>>n;
    Node* front=new Node;
    Node* rear=front;
    for(int i=1;i<=n;i++){
        rear->data=i;
        if(i!=n) {
            rear->next = new Node;
            rear = rear->next;
        }
        else {rear->next=front;rear=front;}

    }//给循环队列赋值
    int k;
    cin>>k;
    Node* k_per=find(front,k);
    Node* k_pre;
    while(size(front)!=1) {
        for (int i = 1; i <= k; i++) {
            if (i == k) {
                cout << k_per->data;
                if(k_per==front) front=k_per->next;
                else if(k_per==rear) rear=k_pre;
                k_pre->next = k_per->next;
                k_per = k_per->next;
            } else {
                k_pre = k_per;
                k_per = k_per->next;
            }
        }
    }
    cout<<front->data;
}