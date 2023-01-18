function check(){
    if(!$('input[type=radio][name=loanType]:checked').is(':checked')){
        alert("상환방식을 선택해주세요.");
        return false;
    }
    if($('#loanAmount').val() == ""){
        alert("대출원금을 입력해주세요.");
        return false;
    }
    if($('#interestRate').val() == ""){
        alert("대출이율을 입력해주세요.");
        return false;
    }
    if($('#loanTerm').val() == ""){
        alert("상환개월을 입력해주세요.");
        return false;
    }
    if($('#loanDate').val() == ""){
        alert("대출시작일을 입력해주세요.");
        return false;
    }
}