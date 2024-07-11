"""
아이디 길이 : 3 ~ 15길이
아이디 유효 : 영어 소문자, 숫자, -, _ , .
            마침표는 처음과 끝에 사용할 수 없다. 연속으로 사용도 불가능

추천 7단계
1. 소문자 치환
2. 위 유효한 부분을 제외한 모든 문자를 제거한다.
3. .(마침표)가 연속으로 2번이 있으면 하나로 치환
4. 마침표가 처음이나 끝에 있으면 제거한다.
5. 빈 문자열이라면 "a"를 대입한다.
6. 문자열이 16자 이상이면 15개 문자를 제외한 나머지 문자들을 모두 제거
7. 길이라 2자 이하라면, 마지막 문자를 길이가 3이 될 때 까지 반복한다. 
"""
import re
def check_id(new_id):
    # 1.
    lower_id = new_id.lower()
    # 2.
    cleaned_text = re.sub(r'[^a-z0-9._-]+', '', lower_id)
    # 3. 
    cleaned_text = re.sub(r'\.{2,}', '.', cleaned_text)
    # 4.
    cleaned_text = re.sub(r'(^\.+|\.+$)', '', cleaned_text)
    # 5.
    if cleaned_text == "":
        cleaned_text = "a"
    # 6.
    if len(cleaned_text) >= 16:
        cleaned_text = cleaned_text[:15]
    # 7.
    if len(cleaned_text) <= 2:
        while len(cleaned_text) <= 2:
            cleaned_text += cleaned_text[-1]
            
    return cleaned_text

def solution(new_id):
    answer = check_id(new_id)
    
    if (answer[0] == "."):
        answer = answer[1:]
    elif answer[-1] == ".":
        answer = answer[:-1]


    return answer