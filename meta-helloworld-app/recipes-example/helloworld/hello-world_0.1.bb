DESCRIPTION = "A friendly program that prints Hello World!"
PRIORITY = "optional"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
#SRCREV = "${AUTOREV}"
#PV = "0.1-git${SRCPV}"
SRC_URI = "file://CMakeLists.txt \ 
		   file://hello-world.c \
		  "
S = "${WORKDIR}"
do_compile() {
${CC} ${CFLAGS} ${LDFLAGS} hello-world.c -o helloworld
}
do_install() {
install -d ${D}${bindir}
install -m 0755 helloworld ${D}${bindir}
}

do_unpack_extra() {
	cp -pPR ${WORKDIR}/* ${S} 
 }
addtask unpack_extra after do_unpack before do_patch
