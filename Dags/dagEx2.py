# Importando as bibliotecas que vamos utilizar
from airflow import DAG
from datetime import datetime, timedelta
from airflow.operators.bash_operator import BashOperator
# definição de argumentos básicos
default_args = {
   'owner': '11ABD',
   'depends_on_past': False,
   'start_date': datetime(2021, 3, 31),
   'retries': 0,
   }
# Nomeando a DAG e definindo quando ela vai ser executada (você pode usar argumentos em Crontab também caso queira que a DAG execute por exemplo todos os dias as 8 da manhã)
with DAG(
   'my-first-dag',
   schedule_interval=timedelta(minutes=1),
   catchup=False,
   default_args=default_args
   ) as dag:
# Definindo as tarefas que a DAG vai executar, nesse caso a execução de dois programas Python, chamando sua execução por comandos bash
# O operador Bash, também pode ser utilizado para executar jobs Talend via Sh
t1 = BashOperator(
   task_id='primeiro_job',
   bash_command="""
   cd $AIRFLOW_HOME/dags/BuildsIngestaoDados/JobExportRawData/
   ./JobExportRawData_run.sh
   """)
# Definindo o padrão de execução, nesse caso executamos t1 e depois t2
t1
