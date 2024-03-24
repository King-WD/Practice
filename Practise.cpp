#include <bits/stdc++.h>
using namespace std;
struct Axis{
    int row=0;
    int col=0;
    int data=0;
    int repeat=0;
};
void transform(string &n,vector<vector<Axis>> &grid){
    int row=-2,col;
    for(int i=0;i<n.length();i++){
        if(n[i]=='['){if(row>-2){grid.emplace_back();}row++;col=0;}
        if(n[i]>=48&&n[i]<=57){
            Axis m;
            m.row=row;m.col=col;m.data=n[i]-'0';
            grid[row].push_back(m);
            col++;
        }
    }
}
void re_map0(stack<Axis> re,vector<vector<Axis>> &grid){
    while(!re.empty()){
        grid[re.top().row][re.top().col].repeat=0;
        re.pop();
    }
}
void re_map1(stack<Axis> re,vector<vector<Axis>> &grid){
    while(!re.empty()){
        grid[re.top().row][re.top().col].repeat=1;
        re.pop();
    }
}
int Recordrute(vector<int> &rute,vector<vector<Axis>> &grid){
//    int n=(int)grid.size(),m=(int)grid[0].size();
    int s=0,t=0;
    int current_num=1;
    stack<Axis> rutes;
    stack<Axis> re;
    grid[0][0].repeat=1;
    rutes.push(grid[0][0]);
    int current_x,current_y;
    while(!rutes.empty()){
        current_x=s;current_y=t;
        int i=1;
        while(i<grid[0].size()-t&&t + i > t && t + i <= grid[s][t].data + t&&grid[s][t+i].repeat==0) {
            if (i + 1 < grid[0].size() - t && t + i + 1 > t && t + i + 1 <= grid[s][t].data + t &&
                grid[s ][t+ i+ 1].repeat == 0) {
                i++;continue;
            }
            else {
                grid[s][t + i].repeat = 1;
                current_num++;
                rutes.push(grid[s][t + i]);
                t = t + i;
                cout << s << '\t' << t << endl;
                re_map0(re,grid);
                if (s == grid.size() - 1 && t == grid[0].size() - 1) {
                    rute.push_back((int) rutes.size());
                    re_map1(re,grid);
                    re.push(rutes.top());
                    rutes.pop();
                    Axis pre = rutes.top();
                    s = pre.row;
                    t = pre.col;
                }
            }
        }
        if(current_x==s&&current_y==t){
            int j=1;
             while(j<grid.size()-s&&s + j > s && s + j <= grid[s][t].data + s&&grid[s+j][t].repeat==0) {
                 if(j+1<grid.size()-s&&s + j+1 > s && s + j +1<= grid[s][t].data + s&&
                    grid[s+j+1][t].repeat==0) {
                     j++;continue;
                 }
                 else
                 {
                     grid[s + j][t].repeat = 1;
                     current_num++;
                     rutes.push(grid[s + j][t]);
                     s = s + j;
                     cout << s << '\t' << t << endl;
                     re_map0(re,grid);
                     if (s == grid.size() - 1 && t == grid[0].size() - 1) {
                         rute.push_back((int) rutes.size());
                         re_map1(re,grid);
                         re.push(rutes.top());
                         rutes.pop();
                         Axis pre = rutes.top();
                         s = pre.row;
                         t = pre.col;

                     }
                 }
             }
            if(current_x==s&&current_y==t) {
                re_map1(re,grid);
                re.push(rutes.top());
                rutes.pop();
                    if(!rutes.empty()) {
                        Axis pre = rutes.top();
                        s = pre.row;
                        t = pre.col;
                    }
            }
        }
    }
    sort(rute.begin(),rute.end());
    if(rute.empty())return -1;
    else return rute[0];
}
int main(){
    vector<vector<Axis>> grid;
    vector<int> rute;
    string n;
    getline(cin,n);
    transform(n,grid);
    cout<<grid[0].size();
    cout<<Recordrute(rute,grid);
    return 0;
}
