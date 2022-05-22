import { useEffect, useState } from 'react';
import DataTable from 'components/DataTable';
import DataModal from 'components/DataModal';
import axios from 'axios';
import {Add, Edit, Delete} from '@mui/icons-material';
import {Button, Stack, Grid} from '@mui/material';

const Home = () => {

    const [data, setData] = useState([]);
    const [selected, setSelected] = useState([]);
    const [createOpen, setCreateOpen] = useState(false);
    const [updateOpen, setUpdateOpen] = useState(false);
    const [workCode, setWorkCode] = useState('');
    const [workName, setWorkName] = useState('');
    const [company, setCompany] = useState('');
    const [empName, setEmpName] = useState('');
    const [position, setPosition] = useState('');
    const [task, setTask] = useState('');
    const [telephone, setTelephone] = useState('');

    const handleCreateOpen = () => setCreateOpen(true);
    const handleCreateClose = () => setCreateOpen(false);
    const handleUpdateOpen = () => setUpdateOpen(true);
    const handleUpdateClose = () => setUpdateOpen(false);

    useEffect(() => {
        getData();
    }, []);

    const getData = () => {
        axios.get('/api')
            .then((res) => {
                setData(res.data);
        })
    }

    const createData = () => {
        axios.post(`/api`, {
            workCode: workCode,
            workName: workName,
            company: company,
            empName: empName,
            position: position,
            task: task,
            telephone: telephone,
        }).then(() => {
                getData();
        });
    }

    const updateData = (id) => {
        axios.put(`/api/${id}`, {
            workCode: workCode,
            workName: workName,
            company: company,
            empName: empName,
            position: position,
            task: task,
            telephone: telephone,
        }).then(() => {
                getData();
        })
    }

    const deleteData = (id) => {
        axios.delete(`/api/${id}`)
            .then(() => {
                getData();
        });
    }

    const handleCreateData = () => {
        console.log('onClickCreate');
        createData();
        handleCreateClose();
    }

    const handleUpdateData = () => {
        console.log('onClickUpdate');
        updateData(selected);
        handleUpdateClose();
    }

    const handleDeleteData = () => {
        console.log('onClickDelete');
        selected.map((id) => {
            deleteData(id);
        })
        setSelected([]);
    }

    const checkUpdatable = () => {
        if (selected.length == 1) {
            const editData = data.filter(el => el.empId == selected);

            setWorkCode(editData[0].workCode);
            setWorkName(editData[0].workName);
            setCompany(editData[0].company);
            setEmpName(editData[0].empName);
            setPosition(editData[0].position);
            setTask(editData[0].task);
            setTelephone(editData[0].telephone);

            handleUpdateOpen();
        }
    }

    return (
        <>
            <h1>사원 목록</h1>
            <Grid container justifyContent="center">
                <Stack direction="row" spacing={3} >
                    <Button variant="contained" startIcon={<Add />} onClick={handleCreateOpen}>
                        추가
                    </Button>
                    <Button variant="outlined" startIcon={<Edit />} onClick={checkUpdatable}>
                        수정
                    </Button>
                    <Button variant="outlined" color="error" startIcon={<Delete />} onClick={handleDeleteData}>
                        삭제
                    </Button>
                    {/* <label htmlFor="contained-button-file">
                        <input accept="image/*" id="contained-button-file" multiple type="file" style={{display:'none'}}/>
                        <Button variant="outlined" color="success" startIcon={<FileUpload />} component="span">
                            불러오기
                        </Button>
                    </label> */}
                </Stack>
            </Grid>
            <br/>
            <DataTable setSelected={setSelected} data={data}/>

            {/* 생성 모달 */}
            <DataModal setWorkCode={setWorkCode} setWorkName={setWorkName} setCompany={setCompany} setEmpName={setEmpName} setPosition={setPosition} setTask={setTask} setTelephone={setTelephone}
                open={createOpen} HandleOpen={handleCreateOpen} handleClose={handleCreateClose} handleData={handleCreateData} title='생성' />
            
            {/* 수정 모달 */}
            <DataModal setWorkCode={setWorkCode} setWorkName={setWorkName} setCompany={setCompany} setEmpName={setEmpName} setPosition={setPosition} setTask={setTask} setTelephone={setTelephone}
                workCode={workCode} workName={workName} company={company} empName={empName} position={position} task={task} telephone={telephone} 
                open={updateOpen} HandleOpen={handleUpdateOpen} handleClose={handleUpdateClose} handleData={handleUpdateData} title='수정' />
        </>
    );
}

export default Home;