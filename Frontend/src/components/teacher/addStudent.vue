<!-- 添加学生 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item label="Name">
        <el-input v-model="form.studentName"></el-input>
      </el-form-item>
      <el-form-item label="Sex">
        <el-input v-model="form.sex"></el-input>
      </el-form-item>
      <el-form-item label="Institude">
        <el-input v-model="form.institute"></el-input>
      </el-form-item>
      <el-form-item label="Major">
        <el-input v-model="form.major"></el-input>
      </el-form-item>
      <el-form-item label="Grade">
        <el-input v-model="form.grade"></el-input>
      </el-form-item>
      <el-form-item label="Class">
        <el-input v-model="form.clazz"></el-input>
      </el-form-item>
      <el-form-item label="Phone Num">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item label="ID">
        <el-input v-model="form.cardId"></el-input>
      </el-form-item>
      <el-form-item label="Email">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="Password">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">Create</el-button>
        <el-button type="text" @click="cancel()">Cancel</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      form: { //表单数据初始化
        studentName: null,
        grade: null,
        major: null,
        clazz: null,
        institute: null,
        phone: null,
        email: null,
        password: null,
        cardId: null,
        sex: null,
        role: 2
      }
    };
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/student',
        method: 'post',
        data: {
          ...this.form
        }
      }).then(res => {
        if (res.data.code === 200) {
          this.$message({
            message: 'Add successfully',
            type: 'success'
          })
          this.$router.push({path: '/studentManage'})
        }
      })
    },
    cancel() { //取消按钮
      this.form = {}
    },

  }
};
</script>
<style lang="less" scoped>
.add {
  padding: 0 40px;
  width: 500px;
}
</style>
