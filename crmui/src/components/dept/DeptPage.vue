<script setup>
import { ref } from 'vue';
import $ajax from '../../util/request.js'

const dialogFormVisible = ref(true)
const form = ref([
  {
    depto: 100,
    dname: 'ttc',
    loc: '沈阳市'
  }
])


const loaddata = async () => {
  const path = '/dept/q/find/all'
  const { data: res } = await $ajax.get(path)
  if (res.code == 200) {
    tableData.value = res.retValue
  } else {
    console.log(res)
  }


}

const tableData = ref([
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  }
])
</script>

<template>
  <el-card class="box-card" style="width: 100%;">
    <template #header>
      <div class="card-header">
        <span>部门管理页面</span>
        <div>
          <el-button class="button" @click="dialogFormVisible = true">添加部门</el-button>
          <el-button class="button" @onclick="loaddata">查询部门</el-button>
        </div>

      </div>
    </template>
    <div>
      <el-table :data="tableData" style="width: 80%">
        <el-table-column prop="date" label="Date" width="180" />
        <el-table-column prop="name" label="Name" width="180" />
        <el-table-column prop="address" label="Address" />
      </el-table>
    </div>

    <!-- 添加 -->
    <el-dialog v-model="dialogFormVisible" title="编辑部门数据">
      <el-form :model="form">
        <el-form-item label="部门编号" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="部门名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="部门地址" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" />
        </el-form-item>
        <!-- <el-form-item label="部门名称" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="Please select a zone">
            <el-option label="Zone No.1" value="shanghai" />
            <el-option label="Zone No.2" value="beijing" />
          </el-select>
        </el-form-item> -->
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">Cancel</el-button>
          <el-button type="primary" @click="dialogFormVisible = false">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>
    <!-- <template #footer>Footer content</template> -->
  </el-card>
</template>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 480px;
}
</style>
