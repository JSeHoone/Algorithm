# ext : 어떤 정보를 기준으로 데이터 추출
# val_ext: 뽑아낼 정보의 기준값을 나타내는 정수
# sort_by : 정보를 정렬할 기준
# data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬

# data 내부 [코드번호code, 제조일date, 최대수량maximum, 현재수량remain]
def solution(data, ext, val_ext, sort_by):
    answer = []
    index_ = {
        "code" : 0,
        "date" : 1,
        "maximum" : 2,
        "remain" : 3,
    }
    
    ext_index = index_[ext]
    sort_index = index_[sort_by]
    
    for info in data:
        if info[ext_index] < val_ext:
            answer.append(info)
    
    answer.sort(key = lambda x : x[sort_index])
        
    return answer