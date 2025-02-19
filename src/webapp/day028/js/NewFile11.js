var score1, score2;

while(true){
    score1 = prompt("숫자 1을 입력해주세요");
    score1 = Number(score1);

    if(score1 < 0 || score1 > 100){
        alert("0~100 사이의 숫자만 입력해주세요!");
        continue;
    }
    break;
}

while(true){
    score2 = prompt("숫자 2를 입력해주세요");
    score2 = Number(score2);

    if(score2 < 0 || score2 > 100){
        alert("0~100 사이의 숫자만 입력해주세요!");
        continue;
    }
    break;
}

const avg = (score1 + score2) / 2;

if(avg > 60){
    document.write("숫자1 : " +score1, " 숫자2 : " + score2, " 평균 : " + avg);
    document.write("통과!");
} else {
    document.write("숫자1 : " +score1, " 숫자2 : " + score2, " 평균 : " + avg);
    document.write("\n실패!")
}