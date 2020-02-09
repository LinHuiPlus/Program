//
//  main.cpp
//  Program_Practice2
//
//  Created by 张林辉 on 2020/2/9.
//  Copyright © 2020 张林辉. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string.h>
using namespace std;

const int SPEED = 17;
const int FLASH = 60;
const int PERCONSUME = 10;

int main(int argc, const char * argv[]) {
    // insert code here...
    int M, S, T, distance = 0, time;
    bool flag = false;
    cin >> M >> S >> T;
    time = T;
     
    while(T--){
        
        if(S - distance <= SPEED){
            flag = true;
            break;
        }
        
        if(M >= PERCONSUME){
            distance += FLASH;
            M -= PERCONSUME;
        }
        else if(T == 0) distance += SPEED;
        else{
            if(M >= 6) M += 4;
            else if(M >= 2 && T < 2) distance += SPEED;
            else if(M >= 2 && T >= 2) M += 4;
            else if(M < 2){
                
                if(T <= 5){
                    
                    int temp = SPEED * (T + 1);
                    if((S - distance) > temp){
                        distance += temp;
                        T = 0;
                        break;
                    }
                    else if((S - distance) < temp){
                        int tt = (S - distance)/SPEED;
                        if(tt * SPEED + distance >= S){
                            T = T - tt + 1;
                            flag = true;
                            break;
                        }
                        else{
                            T = T - tt;
                            flag = true;
                            break;
                        }
                    }
                    else{
                        T = 0;
                        flag = true;
                        break;
                    }
                }
                else{
                    
                    if(S - distance >= 120){
                        distance += 120;
                        T -= 6;
                    }
                    else{
                        //7秒内就能逃掉
                        int tt = (S - distance)/SPEED;
                        if(tt * SPEED + distance >= S){
                            T = T - tt + 1;
                            flag = true;
                            break;
                        }
                        else{
                            T = T - tt;
                            flag = true;
                            break;
                        }
                    }
                }
                
            }
        }
        
        if(distance >= S){
            flag = true;
            break;
        }
    }
    
    if(flag) cout << "Yes" << '\n' << time - T << endl;
    else cout << "No" << '\n' << distance << endl;
    
    return 0;
}
