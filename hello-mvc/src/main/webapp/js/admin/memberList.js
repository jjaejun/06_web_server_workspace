const frm = document.memberRoleUpdateFrm;
const id = frm.id;
const role = frm.role;
/**
 * dataset
 * - html 태그에 데이터를 저장하는 속성
 * - data-xxx : 여러 단어인 경우 단어 단위로 '-'연결
 *  - data-id
 *  - data-user-pet
 *
 * - (getter)
 * - 가져올때는 태그객체의 dataset속성으로부터 key값을 참조(camelCasing)
 */
document.querySelectorAll(".member-role").forEach((select) => {
    select.addEventListener('change', (e) => {
        const {value} = e.target;
        // console.log(e.target.value);

        const {id : idVal} = e.target.dataset
        // console.log(e.target.dataset);
        // console.log(idVal, value);

        if(confirm(`${idVal}회원을 ${value == 'A' ? '관리자' : '일반회원'}로 변경하시겠습니까? 😁`)) {
            role.value = value;
            id.value = idVal;
            frm.submit();
        } else {
            // 원래 선택했던 값(selected)으로 복귀
            e.target.querySelector("[selected]").selected = true;
        }
    });
});