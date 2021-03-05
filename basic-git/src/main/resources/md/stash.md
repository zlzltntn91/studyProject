
## git stash

브랜치에서 파일을 수정하고 커밋하지 않은 상태에서 급하게 다른 파일을 커밋해야할 경우,
**커밋하지 않고 수정한 파일들을 잠시 감추어둘 수 있음**, 당장 필요한 작업들을 끝낸 후 **다시 감춰둔 파일을 꺼내오는 기능**

stash 명령을 사용하려면 파일이 **tracked 상태여야 함**, 즉 한 번은 커밋한 상태여야한다.
```commandline
# git stash

# git stash save
```

### - stash 목록 확인
가장 최근에 보관한것이 stash@{0}, 다른 파일이 추가되면 stash@{1}로 이동하며 이와같은 이유로 stash stack(LIFO) 이라고 표현

```commandline
# git stash list
stash@{0}: WIP on master: 4d3bbf2 f2
stash@{1}: WIP on master: 4d325f1 f3
stash@{2}: WIP on master: 4d343ff f4
stash@{3}: WIP on master: 4d523f3 f5
```

### - stash에 저장된 최신 수정 항목을 불러오기
```commandline
# git stash pop
```

### - stash에 저장된 최신 수전 항목을 꺼내오더라도 stash stack에선 제거하지 않기
```commandline
# git stash apply
```
### - stash에 저장한 최신 수정 항목을 삭제하기
```commandline
# git stash drop
```
