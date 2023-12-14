import { ElMessage } from "element-plus";

const OkMsg = ()=> {
    ElMessage({
        message: '请注意这是一个成功操作',
        type: 'success'
    })
}

const InfoMsg = (msg) => {
    ElMessage({
        message: msg,
        type: 'info'
    })
}

const ErrorMsg = () => {
    ElMessage.error('请注意，你收到一个操作失败的提醒。')
}

export {OkMsg , InfoMsg ,ErrorMsg}