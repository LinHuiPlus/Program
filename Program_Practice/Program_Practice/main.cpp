//
//  main.cpp
//  Program_Practice
//
//  Created by 张林辉 on 2020/2/8.
//  Copyright © 2020 张林辉. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string.h>
using namespace std;

int main(int argc, const char * argv[]) {
    // insert code here..
    int n;
    string s;
    vector<string> v;
    cin >> n;
    cin.get();                  //读取缓存中的回车
    while(getline(cin, s)){
        v.push_back(s);
    }

    auto b = v.begin();
    while(n--){
        cout << *b << endl;
        b++;
        if(b == v.end()){
            break;
        }
        cout << endl;
    }
    
    if(b == v.end()) return 0;
    
    while(b != v.end()){
        s = *b;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == ' ') cout << '\n' << endl;
            else cout << s[i];
        }
        cout << endl;
        b++;
        if(b != v.end()) cout << endl;
    }
    
    return 0;
}
