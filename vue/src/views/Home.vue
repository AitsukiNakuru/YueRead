<template>
  <div style="padding:20px">
    <!--    功能按钮区-->
    <div style="padding: 20px">
      <el-button type="primary" @click="add">增加</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <!--    搜索框区-->
    <div>
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%;padding: 10px" clearable/>
      <el-button type="primary" @click="load">查询</el-button>
    </div>
    <!--    数据展示区-->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="id"    label="ID"  />
      <el-table-column prop="admin_username"    label="用户名"  />
      <el-table-column prop="psw" label="密码" />
      <el-table-column prop="nickname" label="昵称" />
      <el-table-column prop="address" label="地址" />
      <el-table-column fixed="right" prop="phone" label="电话" />
      <!--      行操作-->
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-popconfirm title="你确定要删除吗？" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button link type="primary" size="small" >删除</el-button>
            </template>
          </el-popconfirm>
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 20px">
      <!-- page-sizes 分页    -->
      <el-pagination
          v-model:currentPage="currentPage"
          v-model:page-size="pageSize"
          :page-sizes="[10, 20, 40, 80]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"/>
      <!--      对话框：新增按钮通过add方法使dialogVisible为true来打开它-->
      <el-dialog v-model="dialogVisible" title="提示" width="30%" >
        <el-form  :model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input v-model="form.name"  style="width:80%" />
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.psw"  style="width:80%" />
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickname"  style="width:80%" />
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="form.phone"  style="width:80%" />
          </el-form-item>
          <el-form-item label="地址">
            <el-input type="textarea" v-model="form.address"  style="width:80%" />
          </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
              <el-button @click="dialogVisible = false">取消</el-button>
              <el-button type="primary" @click="save">确定</el-button>
            </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request1 from "../../utils/request";

export default {
  name: "Content",
  components:{

  },
  data(){
    return {
      form:{},
      currentPage:1,
      pageSize:10,
      search:'',
      total:0,
      dialogVisible:false,
      tableData:[
      ]
    }
  },
  created() {
    this.load();
  },
  methods:{
    load(){
      request1.get("/admin", {//get方法返回promise
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          search:this.search
        }
      }).then(res =>{//res（response）是后台响应的数据
        console.log(res)
        this.tableData= res.data.records;
        this.total=res.data.total;
      });
    },
    add(){
      this.dialogVisible=true;
      this.form={};//必须清空上次输入的内容，因为对话框实际一直是打开的，只是通过dialogVisible设置了隐藏，所以如果不清空，这次添加时上次输入的数据仍然显示在对话框
    },
    save(){
      if(this.form.id){//更新（编辑），新增按钮会调用add（），this.form={}让this.form.id=null,使if判断条件为false；而编辑按钮this.form.id！=null,这样判断条件就为true
        request1.put("/admin",this.form).then(res=>{
          // console.log(res)
          if(res.code==='0') {
            this.$message({
              type: "success",
              message: "更新成功"
            })
          }
          else {
            this.$message({
              type: "error",
              message: res.msg,
            });
          }
          this.load();
          this.dialogVisible=false
        })
      }
      else {//新增
        request1.post("/admin", this.form).then(res => {
          // console.log(res)
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "添加成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg,
            });
          }
          this.load();
          this.dialogVisible = false
        })
      }
    },
    handleDelete(id){
      request1.delete("/admin/"+id).then(res=>{//注意admin后面有/
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "删除成功"
          })
        } else {
          this.$message({
            type: "error",
            message: res.msg,
          });
        }
        this.load();
      })
    },
    handleEdit(row){
      console.log("row")
      console.log(row)
      this.form=JSON.parse(JSON.stringify(row))
      this.dialogVisible=true
    }
    ,
    handleSizeChange(pagesize){
      this.pageSize=pagesize
      this.load()
    },
    handleCurrentChange(currentpage){
      this.currentPage=currentpage
      this.load()
    }
  }
}
</script>

<style scoped>

</style>