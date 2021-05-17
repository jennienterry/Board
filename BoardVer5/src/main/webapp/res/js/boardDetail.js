function delCmt(iboard, icmt) {
	console.log(`iboard: ${iboard}, icmt: ${icmt}`)
	//``EL식 아님, javascript문법임
	if(confirm('삭제하시겠습니까?')){
	location.href= `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}