// #1. 개행의 경우가 발생할 경우, 개행 이후의 입력내용을 mysql에 저장



// #1-1. 학력
let degreeTextarea1 = document.getElementById('degree');
let degreeValue1 = degreeTextarea1.value;
let degreeWithLineBreaks1 = degreeValue1.replace(/\n/g, '<br>');
degreeTextarea1.value = degreeWithLineBreaks1;

// #1-2. 경력
let degreeTextarea2 = document.getElementById('career');
let degreeValue2 = degreeTextarea2.value;
let degreeWithLineBreaks2 = degreeValue2.replace(/\n/g, '<br>');
degreeTextarea2.value = degreeWithLineBreaks2;

// #1-3. 대외활동/수상이력 
let degreeTextarea3 = document.getElementById('activity');
let degreeValue3 = degreeTextarea3.value;
let degreeWithLineBreaks3 = degreeValue3.replace(/\n/g, '<br>');
degreeTextarea3.value = degreeWithLineBreaks3;

// #1-4. 보유자격증
let degreeTextarea4 = document.getElementById('certificate');
let degreeValue4 = degreeTextarea4.value;
let degreeWithLineBreaks4 = degreeValue1.replace(/\n/g, '<br>');
degreeTextarea4.value = degreeWithLineBreaks4;

// #1-5. 자기소개
let degreeTextarea5 = document.getElementById('intro');
let degreeValue5 = degreeTextarea5.value;
let degreeWithLineBreaks5 = degreeValue5.replace(/\n/g, '<br>');
degreeTextarea5.value = degreeWithLineBreaks5;