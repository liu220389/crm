<template>
    <div id="login-view">
        <div class="login-div">
            <div id="hader">
                <span>注册新的账号</span><br>
                <span style="font-size: 14px;">已经拥有账号?&nbsp;&nbsp;<a href="#" style="color: #3399FF;">去登陆</a></span>
            </div>


            <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules" label-width="25%" class="demo-ruleForm"
                style="width: 90%;">
                <el-form-item label="账号" prop="account">
                    <el-input v-model="ruleForm.account" autocomplete="off" />
                </el-form-item>
                <el-form-item label="昵称" prop="nickname">
                    <el-input v-model.number="ruleForm.nickname" />
                </el-form-item>
                <el-form-item label="密码" prop="pass">
                    <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />
                </el-form-item>
                <el-form-item label="确认密码" prop="checkPass">
                    <el-input v-model="ruleForm.checkPass" type="password" autocomplete="off" />
                </el-form-item>
                <div id="fuxuan">
                    <input type="checkbox" name="fuxuan" id="">接受我们的条款、数据使用政策和Cookie政策。<br>
                    <input type="checkbox" name="fuxuan" id="">接受我们的短信通知，并可以随时退订。
                </div>

                <el-form-item>
                    <button class="register-button" @click="registerWith">注册</button>
                    <button class="register-button" @click="registerWithWeiBo" style="color: #FF9966;background-color: #fff; border-color: #ff935e;">使用微博账号注册</button>
                    <button class="register-button" @click="registerWithWeiXin" style="color: #00cf9e;background-color: #fff; border-color: #00cf9e;">使用微信账号注册</button>
                    <!-- <el-button type="primary" @click="submitForm(ruleFormRef)">Submit</el-button>
                    <el-button @click="resetForm(ruleFormRef)">Reset</el-button> -->
                </el-form-item>

                
            </el-form>

        </div>
    </div>
</template>
  

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import axios from '../../src/util/request.js'
import type { FormInstance, FormRules } from 'element-plus'

const ruleFormRef = ref<FormInstance>()




const validatePass = (rule: any, value: any, callback: any) => {
    if (value === '') {
        callback(new Error('密码不能为空'))
    } else {
        if (ruleForm.checkPass !== '') {
            if (!ruleFormRef.value) return
            ruleFormRef.value.validateField('checkPass', () => null)
        }
        callback()
    }
}


const validatePass2 = (rule: any, value: any, callback: any) => {
    if (value === '') {
        callback(new Error('请再次输入密码'))
    } else if (value !== ruleForm.pass) {
        callback(new Error("密码输入不一致!"))
    } else {
        callback()
    }
}

const ruleForm = reactive({
    pass: '',
    checkPass: '',
    nickname:'',
    account: 736950,
})


const rules = reactive<FormRules<typeof ruleForm>>({
    pass: [{ validator: validatePass, trigger: 'blur' }],
    checkPass: [{ validator: validatePass2, trigger: 'blur' }],
    
    account: [
        { required: true, message: '请输入您的账号', trigger: 'blur' },
        { min: 6, max: 16, message: '您的账号长度应该有6-16个字符', trigger: 'blur' },
    ],
    nickname: [
        { required: true, message: '请输入昵称', trigger: 'blur' },
        {
            validator: (rule: any, value: any, callback: any) => {
                const pattern = /^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
                if (!pattern.test(value)) {
                    callback(new Error('昵称必须为中文和其他字符组合'));
                } else if (value.length > 10) {
                    callback(new Error('昵称长度不能超过10个字符'));
                } else {
                    callback();
                }
            },
            trigger: 'blur',
        },
    ],
})


// const submitForm = (formEl: FormInstance | undefined) => {
//     if (!formEl) return
//     formEl.validate((valid) => {
//         if (valid) {
//             console.log('submit!')
//         } else {
//             console.log('error submit!')
//             return false
//         }
//     })
// }

// const resetForm = (formEl: FormInstance | undefined) => {
//     if (!formEl) return
//     formEl.resetFields()
// }

const registerWith =async () => {
    // 处理普通注册
    try {
    // 构建要发送到服务器的数据对象
    const data = {
      account: ruleForm.account,
      password: ruleForm.pass,

      // 其他需要发送的字段
    };

    // 发送 POST 请求到服务器
    const response = await axios.post('your-server-endpoint', data);

    // 处理服务器响应
    console.log('Server Response:', response.data);

    // 如果需要进行后续处理，可以在这里添加逻辑
  } catch (error) {
    // 处理错误
    console.error('Error during registration:', error.message);
  }
}

const registerWithWeiBo = () => {
    // 处理使用微博注册
}

const registerWithWeiXin = () => {
    // 处理使用微信注册
}
</script>

<style scoped>
#login-view .login-div #hader {
    width: 100%;
    height: 80px;
    text-align: center;
    margin: 0 auto;
    font-size: 24px;
    font-family: 微软雅黑;
    line-height: 120%;

}

#login-view {
    width: 100%;
    height: 600px;
    background-color: #ceedee;
    padding-top: 100px;

}

#login-view .login-div {

    width: 400px;
    height: 500px;
    margin: 0 auto;
    background-color: #fff;
    padding-top: 45px;

}

#login-view .login-div #fuxuan {
    width: 100%;
    height: 70px;
    line-height: 20px;
    text-align: left;
    font-size: 14px;
    color: #666666;
    padding-left: 59px;
}
.register-button {
    margin-right: 10px;
    background-color: #3399FF;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 275px;
    height: 25px;
    margin-bottom: 15px;
    line-height: 6px;
    font-size: 11px;
    border: 1px solid #3399FF;
}
</style>
  