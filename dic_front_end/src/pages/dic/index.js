import React from "react";
import "./index.css";
import { Table, Row, Col, Pagination, Tree, Button, Tabs, Form, Input, Radio } from "antd";
import { 
  DeleteOutlined, 
  FileAddOutlined, 
  CloudUploadOutlined, 
  CloudDownloadOutlined, 
  FolderAddOutlined,
  ArrowUpOutlined,
  ArrowDownOutlined
} from "@ant-design/icons";

import 'antd/dist/antd.css';

class Dic extends React.Component {
    constructor(props) {
      super(props);
      this.setState({});
    }

    render () {
      const columns = [
        {
          title: '字典编码',
          dataIndex: 'dicCode',
          key: 'dicCode'
        },
        {
          title: '字典名称',
          dataIndex: 'dicName',
          key: 'dicName'
        },
        {
          title: '状态',
          dataIndex: 'fgActive',
          key: 'fgActive',
          render(text, reord) {
            return <>{text === '1' ? '激活' : "注销"}</>
          }
        }
      ];
      const data = [
        {
          key: '1',
          dicCode: 'fg',
          dicName: '是否',
          fgActive: "1"
        }
      ];
      const treeData = [
        {
          title: (<>
            <span>国标字典</span>
            <Button size="small" icon={<ArrowUpOutlined />} type="text"title="新增分类" style={{ float: 'right' }}></Button>
            <Button size="small" icon={<ArrowDownOutlined />} type="text"title="新增分类" style={{ float: 'right' }}></Button>
          </>),
          key: '1',
          children: [
            {
              title: '性别',
              key: '1-1',
            },
            {
              title: '国籍',
              key: '1-2',
            }
          ]
        },
        {
          title: '地方字典',
          key: '2',
          children: [
          ]
        }
      ];
      const layout = {
        labelCol: { flex: '100px' }
      };
      return <>
        <div className="dic-wrap row-block-border">
          <Row style={{ height: '100%' }}>
            <Col flex="300px">
              <Row style={{ textAlign: "right", padding: '5px' }}>
                <Button size="small" icon={<FolderAddOutlined />} type="text"title="新增分类"></Button>
                <Button size="small" icon={<FileAddOutlined />} type="text" disabled={true} title="新增字典"></Button>
                <Button size="small" icon={<DeleteOutlined />} type="text" disabled={true} title="删除分类/字典"></Button>
                <Button size="small" icon={<CloudUploadOutlined />} type="text" title="上传字典"></Button>
                <Button size="small" icon={<CloudDownloadOutlined />} type="text" title="下载字典"></Button>
              </Row>
              <Tree
                showLine
                treeData={treeData}
                style={{ padding: '5px' }}
                />
            </Col>
            <Col flex="auto" style={{ marginLeft: '10px', padding: '5px' }}>
              <Tabs onChange={()=>{}} type="card">
                <Tabs.TabPane tab="基本信息" key="1">
                  <Form 
                    {...layout} size="small">
                    <Form.Item
                      label="字典编码"
                      name="dicCode"
                    >
                      <Input style={{ maxWidth: '300px' }} />
                    </Form.Item>
                    <Form.Item
                      label="字典名称"
                      name="dicName"
                    >
                      <Input style={{ maxWidth: '300px' }} />
                    </Form.Item>
                    <Form.Item
                      label="状态"
                      name="fgActive"
                    >
                      <Radio.Group defaultValue="1" buttonStyle="solid">
                        <Radio.Button value="1">激活</Radio.Button>
                        <Radio.Button value="0">注销</Radio.Button>
                      </Radio.Group>
                    </Form.Item>
                  </Form>
                </Tabs.TabPane>
                <Tabs.TabPane tab="字典项" key="2">
                  <Table
                    size="small"
                    columns={columns} 
                    dataSource={data} 
                    style={{ height: 'calc(100vh - 128px)', backgroundColor: '#f8f7f6' }}
                    pagination={false}
                    // scroll={{ y:'calc(100vh - 0)' }} 
                    />
                  <Pagination defaultCurrent={1} current={1} pageSize={10} total={30} style={{ float: 'right', margin: '10px' }} />
                </Tabs.TabPane>
              </Tabs>
              
            </Col>
          </Row>
        </div>
      </>
    }
}

export default Dic;
