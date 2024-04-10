//
// Created by 魏栋 on 2024/4/8.
//
#include<bits/stdc++.h>
using namespace std;
typedef vector<pair<char,int>> X_exp;
struct Node{
    float cof=0;
    X_exp unkown={{'N',0}};
};
class Poly{
    vector<Node> nomial;
public:
    void Input();
    void X_judge(string &poly,Node &current,int &i,bool&label);
    string Multiply(Poly& poly);
};
int main(){
    Poly poly1;
    Poly poly2;
    poly1.Input();
    poly2.Input();
    cout<<poly1.Multiply(poly2);
    return 0;
}
void Poly::Input() {
    string poly;
    getline(cin,poly);
    Node current;
    bool label=true;
    for(int i=0;i<poly.length();i++){
        if(poly[i]=='+'||poly[i]=='-') {
            if(label) {
                    if(i-1>=0)
                    {
                        if(i-2>=0) {
                            if(poly[i-2]=='+'){
                            current.cof=(float)(poly[i-1]-'0');
                            current.unkown.clear();//将未知数容器清空
                            current.unkown.emplace_back('N',0);
                            nomial.emplace_back(current);
                            }
                            else {
                                    current.cof=-(float)(poly[i-1]-'0');
                                    current.unkown.clear();
                                    current.unkown.emplace_back('N',0);
                                    nomial.emplace_back(current);
                            }
                        }
                        else {
                            current.cof=(float)(poly[i-1]-'0');
                            current.unkown.clear();
                            current.unkown.emplace_back('N',0);
                            nomial.emplace_back(current);
                        }
                    }
            }
            else label=true;current.unkown.clear();
        }
        else if(i==poly.length()-1&&poly[i]>='0'&&poly[i]<='9'
        &&(poly[i-1]<='a'||poly[i-1]>='z')){
            if(poly[i-1]=='+') {
                current.cof=(float)(poly[i]-'0');
                current.unkown.clear();
                current.unkown.emplace_back('N',0);
                nomial.emplace_back(current);

            }
            else{
                current.cof=-(float)(poly[i]-'0');
                current.unkown.clear();
                current.unkown.emplace_back('N',0);
                nomial.emplace_back(current);

            }
        }
        X_judge(poly,current,i,label);
    }
}
void Poly::X_judge(string &poly,Node& current,int& i,bool& label){
    if((poly[i]>='a'&&poly[i]<='z'||poly[i]>='A'&&poly[i]<='Z')){
        if(label&&i-2>=0&&poly[i-1]>='0'&&poly[i-1]<='9'){
            if(poly[i-2]=='+') {current.cof=(float)(poly[i-1]-'0');label=false;}
            else  {current.cof=-(float)(poly[i-1]-'0');label=false;}
        }
        else {
            if(i-1>=0&&poly[i-1]=='-'){current.cof=-1;label=false;}
            else {current.cof=1;label=false;}
        }
        if(i+1<=poly.length()){
            if(poly[i+1]>='0'&&poly[i+1]<='9'){
                current.unkown.clear();
                current.unkown.emplace_back(poly[i],poly[i+1]-'0');
                nomial.emplace_back(current);
            }
            else if(poly[i+1]=='('){
                current.unkown.clear();
                current.unkown.emplace_back(poly[i],-(poly[i+3]-'0'));
                nomial.emplace_back(current);
                i+=4;
            }
            else {
                current.unkown.clear();
                current.unkown.emplace_back(poly[i],1);
                nomial.emplace_back(current);
            }
        }
        else {
            current.unkown.clear();
            current.unkown.emplace_back(poly[i],1);
            nomial.emplace_back(current);
        }
    }
}
string Poly::Multiply(Poly& poly) {
    string multiply;
    vector<Node> result;
    for(auto q:nomial){
        sort(q.unkown.begin(),q.unkown.end());
        //先对当前多项式的项的未知数进行排序，方便比较未知数是否相同
        for(auto p:poly.nomial){
            sort(p.unkown.begin(),p.unkown.end());
            X_exp tem0;
            if(q.unkown.size()>p.unkown.size()) tem0=q.unkown;
            else if(q.unkown.size()==p.unkown.size()){
                if(q.unkown[0]==pair<char,int>{'N',0})
                tem0=p.unkown;
                else tem0=q.unkown;
            }
            else tem0=p.unkown;
            if(q.unkown[0]!=pair<char,int>{'N',0}&&p.unkown[0]!=pair<char,int>{'N',0}) {
                for (int i = 0; i < min(q.unkown.size(), p.unkown.size()); i++) {
                    tem0[i].second = q.unkown[i].second + p.unkown[i].second;
                }
            }
            bool find=false;
            for(int j=0;j<result.size();j++){
                if(result[j].unkown==tem0) {
                    result[j].cof+=q.cof*p.cof;
                    find=true;
                    break;
                }
            }
            if(!find){
                Node tem1={q.cof*p.cof,tem0};
                result.emplace_back(tem1);}
        }
    }
    //将结果输入到multiply中
    int one=1;
    for(auto& pp:result){
        if(pp.cof<0) {
        multiply.push_back('-');
        multiply.push_back((char)(-pp.cof+'0'));
        one=0;
        }
        else {
            if(one)
            {
            multiply.push_back((char)(pp.cof+'0'));
            one=0;
            }
            else {
                multiply.push_back('+');
                multiply.push_back((char)(pp.cof+'0'));
            }
        }
        for(auto qq:pp.unkown) {
            if (qq.first != 'N' && qq.second != 0) {
                multiply.push_back(qq.first);
                multiply.push_back((char) (qq.second + '0'));
            }
        }
    }
    return multiply;
}