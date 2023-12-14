import axios from 'axios'

// 默认的全局配置
axios.defaults.baseURL = 'https://apis.tianapi.com'
// baseURL在所有请求发生之前，为url路径默认增加的前缀
// https://apis.tianapi.com/wxnew/index   ---- 简写为 ------  》  /wxnew/index
axios.defaults.headers.common['Authorization'] = 'ttc'
// 默认的在所有请求的request对象的header增加键值对： Authorization =  Token
// 所有的post请求类型参考form表单的post进行数据封装
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf8'
//  以上修改能够影响所有的aiios对象

// 实例配置 ，单例模式，

const instance = axios.create({
  baseURL: 'http://127.0.0.1:18080', // 此处可以修改--- 》 PORT
  timeout: 5000, // 请求等待时间
  // `responseType` 表示服务器响应的数据类型，可以是 'arraybuffer', 'blob', 'document', 'json', 'text', 'stream'
  responseType: 'json' // 默认的
})

export default instance
