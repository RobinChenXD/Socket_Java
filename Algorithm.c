//顺序表的查找运算
int Locate(SeqList L,ElemType e){
	int i=0;   //i为扫描计数器，初值为0，即从第一个元素开始比较
	while((i<=L.last)&&(L.elem[i]!=e))
		i++;
	if(i<=L.last)
		return(i+1);
	else
		return(-1);
}
//在顺序表L中第i个数据元素之前插入一个元素e。插入前表长n=L->last+1,
//i的合法取值范围是1<=i<=L->last+2
int InsList(SeqList *L,int i,ElemType e){
	int k;
	if((i<1)||(i>L->last+2)){//首先判断插入位置是否合法
		printf("插入的位置i值不合法")；
		return(ERROR);
	}
	if(L->last>=MAXSIZE-1){
		printf("表已满无法插入");
		return(ERROR);
	}
	for(k=L->last;k>=i-1;k--)//为插入元素而移动位置
		L->elem[k+1]=L->elem[k]；
	L->elem[i-1]=e;//在C语言数组中，第i个元素的下标为i-1
	L-last++;
	return(OK);
}
//在顺序表L中删除第i个元素，并用指针参数e返回其值。i的合法取值为1<=i<=L.last+1
int DelList(SeqList *L,int i,ElemType *e){
	int k;
	if((i<1)||(i>L->last+1)){
		printf("删除位置不合法！");
		return(ERROR);
	}
	*e=L->elem[i-1];
	for(k=i;i<=L->last;k++)
		L->elem[k-1]=L->elem[k];
	L->last--;
	return(OK);
}
//顺序表的合并
void merge(SeqList *LA,SeqList *LB,SeqList *LC){
	int i,j,k;
	i=0;j=0;k=0;
	while(i<=LA->last&&j<=LB->last){
		if(LA->elem[i]<=LB->elem[i]){
			LC->elem[k]=LA->elem[i];
			i++;
			k++;
		}else{
			LC->elem[k]=LB->elem[j];
			i++;
			k++;
			while(j<=LA-r->ast){
				LC->elem[k]=LB->elem[j];
				i++;
				k++;
			}
		}
    }
		while(j<=LB->last){

		}

		

	
}































