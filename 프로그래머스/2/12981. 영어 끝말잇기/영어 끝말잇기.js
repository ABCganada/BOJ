function solution(n, words) {
    let answer = [0, 0];
    let round = Math.ceil(words.length/n);
    console.log(Math.ceil(round));
    
    for(let i=1; i<=round; i++){ //회차   //10 3 4
        for(let j=(i-1)*n; j<i*n; j++){ //사람 수만큼 반복 i*n=6   01 / 23 / 45
            let flag = true;
            
            if(j===0){
                continue;
            }
            
            if(j === words.length){
                break;
            }
            
            let c1 = words[j-1][words[j-1].length - 1]; // 전 단어 마지막 글자
            let c2 = words[j][0];   //현 단어 첫 그랒
            
            if(c1 !== c2){
                console.log(c1, c2);    //4 5
                answer[0] = j%n + 1;    //누가 
                answer[1] = i;      //몇 회차?
                return answer;
            }
            
            for(let k=0; k<j; k++){
                let tmp = words[k];
                if(tmp === words[j]){
                    flag = false;
                    break;
                }
            }
            
            if(!flag){
                answer[0] = j%n + 1;    //누가 
                answer[1] = i;      //몇 회차?
                return answer;
            }
        }
    }

    return answer;
}