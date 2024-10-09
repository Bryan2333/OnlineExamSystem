<!--管理中心-->
<template>
  <div id='manager'>
    <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
      <h3 class="alter">Change your password</h3>
      <el-form-item label="New" prop="pass" class="pass">
        <el-input type="password" v-model="ruleForm2.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Confirm" prop="checkPass">
        <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
        <el-button @click="resetForm('ruleForm2')">reset</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    const validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please enter your password'));
      } else {
        if (this.ruleForm2.checkPass !== '') {
          this.$refs.ruleForm2.validateField('checkPass');
        }
        callback();
      }
    };
    const validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please enter your password again'));
      } else if (value !== this.ruleForm2.pass) {
        callback(new Error('The password entered twice is inconsistent!'));
      } else {
        callback();
      }
    };
    return {
      ispass: true,
      ruleForm2: {
        pass: '',
        checkPass: ''
      },
      rules2: {
        pass: [
          {validator: validatePass, trigger: 'blur'}
        ],
        checkPass: [
          {validator: validatePass2, trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(typeof this.ruleForm2.pass)
          console.log(this.ruleForm2.pass)
          this.$axios.put(`/student/reset-password`, {
            password: this.ruleForm2.pass,
            studentId: this.$cookies.get("cid")
          }).then(res => {
            if (res.data.msg === "The password was updated successfully") { //修改成功提示
              this.$message({
                message: 'The password was successfully changed...',
                type: 'success'
              })
            }
          })
          this.ruleForm2 = {};
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
#manager .pass label {
  color: red;
  font-size: 18px;
}

#manager {
  width: 600px;
  text-align: center;
  margin: 100px auto 300px;
  height: 60vh;
}

#manager .alter {
  margin: 30px 0px;
}
</style>
